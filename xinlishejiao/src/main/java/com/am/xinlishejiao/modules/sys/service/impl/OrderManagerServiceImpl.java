package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.OrderManagerDao;
import com.am.xinlishejiao.modules.sys.entity.OrderManagerEntity;
import com.am.xinlishejiao.modules.sys.service.OrderManagerService;


@Service("orderManagerService")
public class OrderManagerServiceImpl extends ServiceImpl<OrderManagerDao, OrderManagerEntity> implements OrderManagerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderManagerEntity> page = this.page(
                new Query<OrderManagerEntity>().getPage(params),
                new QueryWrapper<OrderManagerEntity>()
        );

        return new PageUtils(page);
    }

}
