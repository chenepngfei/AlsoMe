package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.AuthPermissionDao;
import com.am.xinlishejiao.modules.sys.entity.AuthPermissionEntity;
import com.am.xinlishejiao.modules.sys.service.AuthPermissionService;


@Service("authPermissionService")
public class AuthPermissionServiceImpl extends ServiceImpl<AuthPermissionDao, AuthPermissionEntity> implements AuthPermissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AuthPermissionEntity> page = this.page(
                new Query<AuthPermissionEntity>().getPage(params),
                new QueryWrapper<AuthPermissionEntity>()
        );

        return new PageUtils(page);
    }

}
