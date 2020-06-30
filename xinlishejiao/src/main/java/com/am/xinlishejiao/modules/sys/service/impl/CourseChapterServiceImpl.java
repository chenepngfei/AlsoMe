package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.CourseChapterDao;
import com.am.xinlishejiao.modules.sys.entity.CourseChapterEntity;
import com.am.xinlishejiao.modules.sys.service.CourseChapterService;


@Service("courseChapterService")
public class CourseChapterServiceImpl extends ServiceImpl<CourseChapterDao, CourseChapterEntity> implements CourseChapterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CourseChapterEntity> page = this.page(
                new Query<CourseChapterEntity>().getPage(params),
                new QueryWrapper<CourseChapterEntity>()
        );

        return new PageUtils(page);
    }

}
