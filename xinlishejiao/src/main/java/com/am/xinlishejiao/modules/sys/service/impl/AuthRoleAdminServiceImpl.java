package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.AuthRoleAdminDao;
import com.am.xinlishejiao.modules.sys.entity.AuthRoleAdminEntity;
import com.am.xinlishejiao.modules.sys.service.AuthRoleAdminService;


@Service("authRoleAdminService")
public class AuthRoleAdminServiceImpl extends ServiceImpl<AuthRoleAdminDao, AuthRoleAdminEntity> implements AuthRoleAdminService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AuthRoleAdminEntity> page = this.page(
                new Query<AuthRoleAdminEntity>().getPage(params),
                new QueryWrapper<AuthRoleAdminEntity>()
        );

        return new PageUtils(page);
    }

}
