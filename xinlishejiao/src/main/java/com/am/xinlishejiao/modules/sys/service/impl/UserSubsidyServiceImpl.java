package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.UserSubsidyDao;
import com.am.xinlishejiao.modules.sys.entity.UserSubsidyEntity;
import com.am.xinlishejiao.modules.sys.service.UserSubsidyService;


@Service("userSubsidyService")
public class UserSubsidyServiceImpl extends ServiceImpl<UserSubsidyDao, UserSubsidyEntity> implements UserSubsidyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserSubsidyEntity> page = this.page(
                new Query<UserSubsidyEntity>().getPage(params),
                new QueryWrapper<UserSubsidyEntity>()
        );

        return new PageUtils(page);
    }

}
