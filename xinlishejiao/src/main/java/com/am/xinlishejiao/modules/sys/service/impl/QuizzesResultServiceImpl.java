package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.QuizzesResultDao;
import com.am.xinlishejiao.modules.sys.entity.QuizzesResultEntity;
import com.am.xinlishejiao.modules.sys.service.QuizzesResultService;


@Service("quizzesResultService")
public class QuizzesResultServiceImpl extends ServiceImpl<QuizzesResultDao, QuizzesResultEntity> implements QuizzesResultService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QuizzesResultEntity> page = this.page(
                new Query<QuizzesResultEntity>().getPage(params),
                new QueryWrapper<QuizzesResultEntity>()
        );

        return new PageUtils(page);
    }

}
