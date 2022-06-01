package com.orchid.navigation.dao;

import com.orchid.navigation.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 网站分类表
 * 
 * @author orchid
 * @email orchid@gmail.com
 * @date 2022-05-24 17:32:42
 */

/**
* 使⽤@mapper后，不需要在spring配置中设置扫描地址，通过mapper.xml⾥⾯的namespace属性对应相关的mapper类，spring 将动态的⽣成Bean后注⼊到ServiceImpl中。
* 使用@repository则需要在Spring中配置扫描包地址，然后⽣成dao层的bean，之后被注⼊到ServiceImpl中
*/
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
