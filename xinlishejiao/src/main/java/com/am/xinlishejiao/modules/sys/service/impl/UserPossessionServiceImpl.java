package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.UserPossessionDao;
import com.am.xinlishejiao.modules.sys.entity.UserPossessionEntity;
import com.am.xinlishejiao.modules.sys.service.UserPossessionService;


@Service("userPossessionService")
public class UserPossessionServiceImpl extends ServiceImpl<UserPossessionDao, UserPossessionEntity> implements UserPossessionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserPossessionEntity> page = this.page(
                new Query<UserPossessionEntity>().getPage(params),
                new QueryWrapper<UserPossessionEntity>()
        );

        return new PageUtils(page);
    }

}
