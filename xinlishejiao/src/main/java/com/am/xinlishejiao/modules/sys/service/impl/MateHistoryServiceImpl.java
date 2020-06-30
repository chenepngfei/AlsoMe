package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.MateHistoryDao;
import com.am.xinlishejiao.modules.sys.entity.MateHistoryEntity;
import com.am.xinlishejiao.modules.sys.service.MateHistoryService;


@Service("mateHistoryService")
public class MateHistoryServiceImpl extends ServiceImpl<MateHistoryDao, MateHistoryEntity> implements MateHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MateHistoryEntity> page = this.page(
                new Query<MateHistoryEntity>().getPage(params),
                new QueryWrapper<MateHistoryEntity>()
        );

        return new PageUtils(page);
    }

}
