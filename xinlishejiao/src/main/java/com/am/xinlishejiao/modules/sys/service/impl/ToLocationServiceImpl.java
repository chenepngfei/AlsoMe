package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.ToLocationDao;
import com.am.xinlishejiao.modules.sys.entity.ToLocationEntity;
import com.am.xinlishejiao.modules.sys.service.ToLocationService;


@Service("toLocationService")
public class ToLocationServiceImpl extends ServiceImpl<ToLocationDao, ToLocationEntity> implements ToLocationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ToLocationEntity> page = this.page(
                new Query<ToLocationEntity>().getPage(params),
                new QueryWrapper<ToLocationEntity>()
        );

        return new PageUtils(page);
    }

}
