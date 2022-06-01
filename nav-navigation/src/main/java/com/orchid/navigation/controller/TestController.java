package com.orchid.navigation.controller;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
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
//@Slf4j
@Api(value = "Test Interfaces", tags = "Test Interfaces")
//@RequestMapping("navigation/test")
@RefreshScope
public class TestController {

    @Value("${member.nickname}")
    private  String nickname;

    @Value("${member.age}")
    private  Integer age;

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
    @ApiOperation("Query test")
    @RequestMapping("/query")
    //@RequiresPermissions("navigation:site:list")
    public R query(){
        return R.ok().put("nickname", nickname).put("age", age);
    }

}
