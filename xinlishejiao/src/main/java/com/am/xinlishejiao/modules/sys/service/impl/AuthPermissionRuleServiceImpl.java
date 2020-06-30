package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.AuthPermissionRuleDao;
import com.am.xinlishejiao.modules.sys.entity.AuthPermissionRuleEntity;
import com.am.xinlishejiao.modules.sys.service.AuthPermissionRuleService;


@Service("authPermissionRuleService")
public class AuthPermissionRuleServiceImpl extends ServiceImpl<AuthPermissionRuleDao, AuthPermissionRuleEntity> implements AuthPermissionRuleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AuthPermissionRuleEntity> page = this.page(
                new Query<AuthPermissionRuleEntity>().getPage(params),
                new QueryWrapper<AuthPermissionRuleEntity>()
        );

        return new PageUtils(page);
    }

}
