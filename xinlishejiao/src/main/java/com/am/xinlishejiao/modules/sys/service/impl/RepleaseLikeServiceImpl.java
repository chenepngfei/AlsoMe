package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.RepleaseLikeDao;
import com.am.xinlishejiao.modules.sys.entity.RepleaseLikeEntity;
import com.am.xinlishejiao.modules.sys.service.RepleaseLikeService;


@Service("repleaseLikeService")
public class RepleaseLikeServiceImpl extends ServiceImpl<RepleaseLikeDao, RepleaseLikeEntity> implements RepleaseLikeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RepleaseLikeEntity> page = this.page(
                new Query<RepleaseLikeEntity>().getPage(params),
                new QueryWrapper<RepleaseLikeEntity>()
        );

        return new PageUtils(page);
    }

}
