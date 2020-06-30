package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.UserRechargeDao;
import com.am.xinlishejiao.modules.sys.entity.UserRechargeEntity;
import com.am.xinlishejiao.modules.sys.service.UserRechargeService;


@Service("userRechargeService")
public class UserRechargeServiceImpl extends ServiceImpl<UserRechargeDao, UserRechargeEntity> implements UserRechargeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserRechargeEntity> page = this.page(
                new Query<UserRechargeEntity>().getPage(params),
                new QueryWrapper<UserRechargeEntity>()
        );

        return new PageUtils(page);
    }

}
