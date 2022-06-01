package com.orchid.navigation.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.orchid.navigation.service.SiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import com.orchid.navigation.entity.SiteEntity;
import com.orchid.common.utils.PageUtils;
import com.orchid.common.utils.R;

/**
 * 网站信息表
 *
 * @author orchid
 * @email orchid@gmail.com
 * @date 2022-05-24 17:32:42
 *
 * @RestController
 *      组合@Controller和@ResponseBody，当你开发一个和页面交互数据的控制时，比如bbs-web的api接口需要此注解
 * @ResponseBody
 *      支持将返回值放在response体内，而不是返回一个页面。比如Ajax接口，可以用此注解返回数据而不是页面。此注解可以放置在返回值前或方法前
 * @Slf4j
 *      如果不想每次都写private final Logger logger = LoggerFactory.getLogger(当前类名.class); 可以用注解@Slf4j
 * @Api
 *      作用在类上，表明是swagger资源，拥有两个属性：value、tags，value不能有多个值，生成的api文档会根据value或tags分类
 *      即这个controller中的所有接口生成的接口文档都会在tags这个list下；tags如果有多个值，会生成多个list,每个list都显示所有接口
 * @RequestMapping
 *      用来映射web请求(访问路径和参数)、处理类和方法，可以注解在类或方法上。注解在方法上的路径会继承注解在类上的路径。
 *      produces属性: 定制返回的response的媒体类型和字符集，或需返回值是json对象
 *      @RequestMapping(value="/api",produces="application/json;charset=UTF-8",method=RequestMethod.POST)
 */
@RestController
@Slf4j
@Api(value = "Site Interfaces", tags = "Site Interfaces")
@RequestMapping("navigation/site")
public class SiteController {
    /**
    * 在默认情况下使用 @Autowired 注释进行自动注入时，Spring 容器中匹配的候选 Bean 数目必须有且仅有一个。
    * 当不能确定 Spring 容器中一定拥有某个类的 Bean 时，可以在需要自动注入该类 Bean 的地方使用 @Autowired(required = false)
    * 这等于告诉 Spring: 在找不到匹配 Bean 时也不报错
    */
    @Autowired
    private SiteService siteService;

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 列表
     *
     * @ApiOperation
     *      作用在方法上，表示一个http请求的操作，value用于方法描述，notes用于提示内容，tags可以重新分组
     * @ApiParam
     *      作用在方法或参数上字段说明；表示对参数的添加元数据（说明或是否必填等），name 参数名，value参数说明，required 是否必填
     * @ApiModel 用对象来接收参数
     * @ApiProperty 用对象接收参数时，描述对象的一个字段
     * @ApiResponse HTTP响应其中1个描述
     * @ApiResponses HTTP响应整体描述
     * @ApiIgnore 使用该注解忽略这个API
     * @ApiError 发生错误返回的信息
     * @ApiImplicitParam 一个请求参数
     * @ApiImplicitParams 多个请求参数
     */
    @ApiOperation("Query SiteList")
    @RequestMapping("/list")
    //@CrossOrigin(origins = "/list"),网关统一配置跨域
    //@RequiresPermissions("navigation:site:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = siteService.queryPage(params);
        log.info("============orchid============="+page.getTotalCount());
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("navigation:site:info")
    public R info(@PathVariable("id") Integer id){
		SiteEntity site = siteService.getById(id);

        return R.ok().put("site", site);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("navigation:site:save")
    public R save(@RequestBody SiteEntity site){
		siteService.save(site);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("navigation:site:update")
    public R update(@RequestBody SiteEntity site){
		siteService.updateById(site);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("navigation:site:delete")
    public R delete(@RequestBody Integer[] ids){
		siteService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
