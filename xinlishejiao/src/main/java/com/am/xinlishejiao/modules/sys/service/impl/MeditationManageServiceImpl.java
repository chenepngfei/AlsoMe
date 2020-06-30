package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.MeditationManageDao;
import com.am.xinlishejiao.modules.sys.entity.MeditationManageEntity;
import com.am.xinlishejiao.modules.sys.service.MeditationManageService;


@Service("meditationManageService")
public class MeditationManageServiceImpl extends ServiceImpl<MeditationManageDao, MeditationManageEntity> implements MeditationManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MeditationManageEntity> page = this.page(
                new Query<MeditationManageEntity>().getPage(params),
                new QueryWrapper<MeditationManageEntity>()
        );

        return new PageUtils(page);
    }

}
