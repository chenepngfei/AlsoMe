package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.AuthAdminDao;
import com.am.xinlishejiao.modules.sys.entity.AuthAdminEntity;
import com.am.xinlishejiao.modules.sys.service.AuthAdminService;


@Service("authAdminService")
public class AuthAdminServiceImpl extends ServiceImpl<AuthAdminDao, AuthAdminEntity> implements AuthAdminService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AuthAdminEntity> page = this.page(
                new Query<AuthAdminEntity>().getPage(params),
                new QueryWrapper<AuthAdminEntity>()
        );

        return new PageUtils(page);
    }

}
