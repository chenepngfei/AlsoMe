package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.BroadcastManageDao;
import com.am.xinlishejiao.modules.sys.entity.BroadcastManageEntity;
import com.am.xinlishejiao.modules.sys.service.BroadcastManageService;


@Service("broadcastManageService")
public class BroadcastManageServiceImpl extends ServiceImpl<BroadcastManageDao, BroadcastManageEntity> implements BroadcastManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BroadcastManageEntity> page = this.page(
                new Query<BroadcastManageEntity>().getPage(params),
                new QueryWrapper<BroadcastManageEntity>()
        );

        return new PageUtils(page);
    }

}
