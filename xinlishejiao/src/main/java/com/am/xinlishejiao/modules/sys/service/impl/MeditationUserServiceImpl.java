package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.MeditationUserDao;
import com.am.xinlishejiao.modules.sys.entity.MeditationUserEntity;
import com.am.xinlishejiao.modules.sys.service.MeditationUserService;


@Service("meditationUserService")
public class MeditationUserServiceImpl extends ServiceImpl<MeditationUserDao, MeditationUserEntity> implements MeditationUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MeditationUserEntity> page = this.page(
                new Query<MeditationUserEntity>().getPage(params),
                new QueryWrapper<MeditationUserEntity>()
        );

        return new PageUtils(page);
    }

}
