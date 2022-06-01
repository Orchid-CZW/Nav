package com.orchid.navigation.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orchid.common.utils.PageUtils;
import com.orchid.common.utils.Query;

import com.orchid.navigation.dao.SiteDao;
import com.orchid.navigation.entity.SiteEntity;
import com.orchid.navigation.service.SiteService;

//用于标注业务层组件
@Service("siteService")
public class SiteServiceImpl extends ServiceImpl<SiteDao, SiteEntity> implements SiteService {

    //重写标识，编译器验证方法名称是否在父类中，如果没有就会报错
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String categoryId = (String)params.get("categoryId");
        IPage<SiteEntity> page = this.page(
                new Query<SiteEntity>().getPage(params),
                new QueryWrapper<SiteEntity>()
                        .eq(StringUtils.isNotBlank(categoryId),"category_id", categoryId)
                        .eq("is_deleted",0)
        );

        return new PageUtils(page);
    }

}