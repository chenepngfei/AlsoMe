package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.UserWithdrawalDao;
import com.am.xinlishejiao.modules.sys.entity.UserWithdrawalEntity;
import com.am.xinlishejiao.modules.sys.service.UserWithdrawalService;


@Service("userWithdrawalService")
public class UserWithdrawalServiceImpl extends ServiceImpl<UserWithdrawalDao, UserWithdrawalEntity> implements UserWithdrawalService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserWithdrawalEntity> page = this.page(
                new Query<UserWithdrawalEntity>().getPage(params),
                new QueryWrapper<UserWithdrawalEntity>()
        );

        return new PageUtils(page);
    }

}
