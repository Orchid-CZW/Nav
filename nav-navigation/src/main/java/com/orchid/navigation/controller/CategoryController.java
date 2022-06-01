package com.orchid.navigation.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orchid.navigation.entity.CategoryEntity;
import com.orchid.navigation.service.CategoryService;
import com.orchid.common.utils.PageUtils;
import com.orchid.common.utils.R;

/**
 * 网站分类表
 *
 * @author orchid
 * @email orchid@gmail.com
 * @date 2022-05-24 17:32:42
 */

/**
* 组合@Controller和@ResponseBody，当你开发一个和页面交互数据的控制时，比如bbs-web的api接口需要此注解
* ResponseBody:支持将返回值放在response体内，而不是返回一个页面。比如Ajax接口，可以用此注解返回数据而不是页面。此注解可以放置在返回值前或方法前。
*/
@RestController
/**
* 用来映射web请求(访问路径和参数)、处理类和方法，可以注解在类或方法上。注解在方法上的路径会继承注解在类上的路径。
* produces属性: 定制返回的response的媒体类型和字符集，或需返回值是json对象
* @RequestMapping(value="/api",produces="application/json;charset=UTF-8",method=RequestMethod.POST)
*/
@RequestMapping("navigation/category")
public class CategoryController {
    /**
    * 在默认情况下使用 @Autowired 注释进行自动注入时，Spring 容器中匹配的候选 Bean 数目必须有且仅有一个。
    * 当不能确定 Spring 容器中一定拥有某个类的 Bean 时，可以在需要自动注入该类 Bean 的地方使用 @Autowired(required = false)
    * 这等于告诉 Spring: 在找不到匹配 Bean 时也不报错
    */
    @Autowired
    private CategoryService categoryService;

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("navigation:category:list")
    public R list(@RequestParam Map<String, Object> params){

        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("navigation:category:info")
    public R info(@PathVariable("id") Integer id){
		CategoryEntity category = categoryService.getById(id);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("navigation:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("navigation:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("navigation:category:delete")
    public R delete(@RequestBody Integer[] ids){
		categoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
