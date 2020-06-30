package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.FollowManageDao;
import com.am.xinlishejiao.modules.sys.entity.FollowManageEntity;
import com.am.xinlishejiao.modules.sys.service.FollowManageService;


@Service("followManageService")
public class FollowManageServiceImpl extends ServiceImpl<FollowManageDao, FollowManageEntity> implements FollowManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FollowManageEntity> page = this.page(
                new Query<FollowManageEntity>().getPage(params),
                new QueryWrapper<FollowManageEntity>()
        );

        return new PageUtils(page);
    }

}
