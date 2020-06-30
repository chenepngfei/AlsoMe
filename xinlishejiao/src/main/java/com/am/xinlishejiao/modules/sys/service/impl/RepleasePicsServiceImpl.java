package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.RepleasePicsDao;
import com.am.xinlishejiao.modules.sys.entity.RepleasePicsEntity;
import com.am.xinlishejiao.modules.sys.service.RepleasePicsService;


@Service("repleasePicsService")
public class RepleasePicsServiceImpl extends ServiceImpl<RepleasePicsDao, RepleasePicsEntity> implements RepleasePicsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RepleasePicsEntity> page = this.page(
                new Query<RepleasePicsEntity>().getPage(params),
                new QueryWrapper<RepleasePicsEntity>()
        );

        return new PageUtils(page);
    }

}
