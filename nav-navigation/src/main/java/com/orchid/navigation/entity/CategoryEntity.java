package com.orchid.navigation.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 网站分类表
 * 
 * @author orchid
 * @email orchid@gmail.com
 * @date 2022-05-24 17:32:42
 */

//注解在类上，相当于同时使用了@ToString、@EqualsAndHashCode、@Getter、@Setter和@RequiredArgsConstrutor这些注解
@Data
//主要是mybatis-plus用于实现 现实实体类型和数据库表映射
@TableName("category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 分类id
	 */
	//mybatis-plus用于标识主键
@TableId
	private Integer id;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 分类名
	 */
	private String title;
	/**
	 * 逻辑删除(1:已删除，0:未删除)
	 */
	private Integer isDeleted;

}
