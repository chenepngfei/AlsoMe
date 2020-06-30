package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.FeedbackManageDao;
import com.am.xinlishejiao.modules.sys.entity.FeedbackManageEntity;
import com.am.xinlishejiao.modules.sys.service.FeedbackManageService;


@Service("feedbackManageService")
public class FeedbackManageServiceImpl extends ServiceImpl<FeedbackManageDao, FeedbackManageEntity> implements FeedbackManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeedbackManageEntity> page = this.page(
                new Query<FeedbackManageEntity>().getPage(params),
                new QueryWrapper<FeedbackManageEntity>()
        );

        return new PageUtils(page);
    }

}
