package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.VideoManageDao;
import com.am.xinlishejiao.modules.sys.entity.VideoManageEntity;
import com.am.xinlishejiao.modules.sys.service.VideoManageService;


@Service("videoManageService")
public class VideoManageServiceImpl extends ServiceImpl<VideoManageDao, VideoManageEntity> implements VideoManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<VideoManageEntity> page = this.page(
                new Query<VideoManageEntity>().getPage(params),
                new QueryWrapper<VideoManageEntity>()
        );

        return new PageUtils(page);
    }

}
