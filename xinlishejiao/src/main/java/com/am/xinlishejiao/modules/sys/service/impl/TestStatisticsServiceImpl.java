package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.TestStatisticsDao;
import com.am.xinlishejiao.modules.sys.entity.TestStatisticsEntity;
import com.am.xinlishejiao.modules.sys.service.TestStatisticsService;


@Service("testStatisticsService")
public class TestStatisticsServiceImpl extends ServiceImpl<TestStatisticsDao, TestStatisticsEntity> implements TestStatisticsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TestStatisticsEntity> page = this.page(
                new Query<TestStatisticsEntity>().getPage(params),
                new QueryWrapper<TestStatisticsEntity>()
        );

        return new PageUtils(page);
    }

}
