package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.VestManageDao;
import com.am.xinlishejiao.modules.sys.entity.VestManageEntity;
import com.am.xinlishejiao.modules.sys.service.VestManageService;


@Service("vestManageService")
public class VestManageServiceImpl extends ServiceImpl<VestManageDao, VestManageEntity> implements VestManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<VestManageEntity> page = this.page(
                new Query<VestManageEntity>().getPage(params),
                new QueryWrapper<VestManageEntity>()
        );

        return new PageUtils(page);
    }

}
