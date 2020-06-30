package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.CardTestDao;
import com.am.xinlishejiao.modules.sys.entity.CardTestEntity;
import com.am.xinlishejiao.modules.sys.service.CardTestService;


@Service("cardTestService")
public class CardTestServiceImpl extends ServiceImpl<CardTestDao, CardTestEntity> implements CardTestService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CardTestEntity> page = this.page(
                new Query<CardTestEntity>().getPage(params),
                new QueryWrapper<CardTestEntity>()
        );

        return new PageUtils(page);
    }

}
