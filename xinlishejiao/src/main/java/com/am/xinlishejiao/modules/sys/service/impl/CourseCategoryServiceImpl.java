package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.CourseCategoryDao;
import com.am.xinlishejiao.modules.sys.entity.CourseCategoryEntity;
import com.am.xinlishejiao.modules.sys.service.CourseCategoryService;


@Service("courseCategoryService")
public class CourseCategoryServiceImpl extends ServiceImpl<CourseCategoryDao, CourseCategoryEntity> implements CourseCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CourseCategoryEntity> page = this.page(
                new Query<CourseCategoryEntity>().getPage(params),
                new QueryWrapper<CourseCategoryEntity>()
        );

        return new PageUtils(page);
    }

}
