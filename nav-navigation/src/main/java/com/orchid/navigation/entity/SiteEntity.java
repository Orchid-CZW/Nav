package com.orchid.navigation.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 网站信息表
 * 
 * @author orchid
 * @email orchid@gmail.com
 * @date 2022-05-24 17:32:42
 */

//注解在类上，相当于同时使用了@ToString、@EqualsAndHashCode、@Getter、@Setter和@RequiredArgsConstrutor这些注解
@Data
//主要是mybatis-plus用于实现 现实实体类型和数据库表映射
@TableName("site")
public class SiteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 站点编号
	 */
	//mybatis-plus用于标识主键
@TableId
	private Integer id;
	/**
	 * 分类编号
	 */
	private Integer categoryId;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 图片
	 */
	private String photo;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 网址
	 */
	private String url;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 逻辑删除(1:已删除，0:未删除)
	 */
	private Integer isDeleted;

}
