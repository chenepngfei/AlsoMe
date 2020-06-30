package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.AdvertManageDao;
import com.am.xinlishejiao.modules.sys.entity.AdvertManageEntity;
import com.am.xinlishejiao.modules.sys.service.AdvertManageService;


@Service("advertManageService")
public class AdvertManageServiceImpl extends ServiceImpl<AdvertManageDao, AdvertManageEntity> implements AdvertManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AdvertManageEntity> page = this.page(
                new Query<AdvertManageEntity>().getPage(params),
                new QueryWrapper<AdvertManageEntity>()
        );

        return new PageUtils(page);
    }

}
