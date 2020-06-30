package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.CommunityUserDao;
import com.am.xinlishejiao.modules.sys.entity.CommunityUserEntity;
import com.am.xinlishejiao.modules.sys.service.CommunityUserService;


@Service("communityUserService")
public class CommunityUserServiceImpl extends ServiceImpl<CommunityUserDao, CommunityUserEntity> implements CommunityUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommunityUserEntity> page = this.page(
                new Query<CommunityUserEntity>().getPage(params),
                new QueryWrapper<CommunityUserEntity>()
        );

        return new PageUtils(page);
    }

}
