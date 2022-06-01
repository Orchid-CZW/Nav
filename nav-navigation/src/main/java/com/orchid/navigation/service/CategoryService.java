package com.orchid.navigation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orchid.common.utils.PageUtils;
import com.orchid.navigation.entity.CategoryEntity;

import java.util.Map;

/**
 * 网站分类表
 *
 * @author orchid
 * @email orchid@gmail.com
 * @date 2022-05-24 17:32:42
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

