package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.CommunityManageDao;
import com.am.xinlishejiao.modules.sys.entity.CommunityManageEntity;
import com.am.xinlishejiao.modules.sys.service.CommunityManageService;


@Service("communityManageService")
public class CommunityManageServiceImpl extends ServiceImpl<CommunityManageDao, CommunityManageEntity> implements CommunityManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommunityManageEntity> page = this.page(
                new Query<CommunityManageEntity>().getPage(params),
                new QueryWrapper<CommunityManageEntity>()
        );

        return new PageUtils(page);
    }

}
