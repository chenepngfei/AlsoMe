package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.LogoManageDao;
import com.am.xinlishejiao.modules.sys.entity.LogoManageEntity;
import com.am.xinlishejiao.modules.sys.service.LogoManageService;


@Service("logoManageService")
public class LogoManageServiceImpl extends ServiceImpl<LogoManageDao, LogoManageEntity> implements LogoManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LogoManageEntity> page = this.page(
                new Query<LogoManageEntity>().getPage(params),
                new QueryWrapper<LogoManageEntity>()
        );

        return new PageUtils(page);
    }

}
