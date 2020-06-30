package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.MateManageDao;
import com.am.xinlishejiao.modules.sys.entity.MateManageEntity;
import com.am.xinlishejiao.modules.sys.service.MateManageService;


@Service("mateManageService")
public class MateManageServiceImpl extends ServiceImpl<MateManageDao, MateManageEntity> implements MateManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MateManageEntity> page = this.page(
                new Query<MateManageEntity>().getPage(params),
                new QueryWrapper<MateManageEntity>()
        );

        return new PageUtils(page);
    }

}
