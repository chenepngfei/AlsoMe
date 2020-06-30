package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.AppealManagerDao;
import com.am.xinlishejiao.modules.sys.entity.AppealManagerEntity;
import com.am.xinlishejiao.modules.sys.service.AppealManagerService;


@Service("appealManagerService")
public class AppealManagerServiceImpl extends ServiceImpl<AppealManagerDao, AppealManagerEntity> implements AppealManagerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AppealManagerEntity> page = this.page(
                new Query<AppealManagerEntity>().getPage(params),
                new QueryWrapper<AppealManagerEntity>()
        );

        return new PageUtils(page);
    }

}
