package com.orchid.navigation.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orchid.common.utils.PageUtils;
import com.orchid.common.utils.Query;

import com.orchid.navigation.dao.CategoryDao;
import com.orchid.navigation.entity.CategoryEntity;
import com.orchid.navigation.service.CategoryService;

//用于标注业务层组件
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    //重写标识，编译器验证方法名称是否在父类中，如果没有就会报错
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
                        .eq("is_deleted",0)
        );

        return new PageUtils(page);
    }

}