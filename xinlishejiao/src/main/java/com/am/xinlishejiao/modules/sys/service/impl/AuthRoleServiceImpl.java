package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.AuthRoleDao;
import com.am.xinlishejiao.modules.sys.entity.AuthRoleEntity;
import com.am.xinlishejiao.modules.sys.service.AuthRoleService;


@Service("authRoleService")
public class AuthRoleServiceImpl extends ServiceImpl<AuthRoleDao, AuthRoleEntity> implements AuthRoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AuthRoleEntity> page = this.page(
                new Query<AuthRoleEntity>().getPage(params),
                new QueryWrapper<AuthRoleEntity>()
        );

        return new PageUtils(page);
    }

}
