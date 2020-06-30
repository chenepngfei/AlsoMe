package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.MyCourseDao;
import com.am.xinlishejiao.modules.sys.entity.MyCourseEntity;
import com.am.xinlishejiao.modules.sys.service.MyCourseService;


@Service("myCourseService")
public class MyCourseServiceImpl extends ServiceImpl<MyCourseDao, MyCourseEntity> implements MyCourseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MyCourseEntity> page = this.page(
                new Query<MyCourseEntity>().getPage(params),
                new QueryWrapper<MyCourseEntity>()
        );

        return new PageUtils(page);
    }

}
