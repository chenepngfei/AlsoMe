package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.CourseManageDao;
import com.am.xinlishejiao.modules.sys.entity.CourseManageEntity;
import com.am.xinlishejiao.modules.sys.service.CourseManageService;


@Service("courseManageService")
public class CourseManageServiceImpl extends ServiceImpl<CourseManageDao, CourseManageEntity> implements CourseManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CourseManageEntity> page = this.page(
                new Query<CourseManageEntity>().getPage(params),
                new QueryWrapper<CourseManageEntity>()
        );

        return new PageUtils(page);
    }

}
