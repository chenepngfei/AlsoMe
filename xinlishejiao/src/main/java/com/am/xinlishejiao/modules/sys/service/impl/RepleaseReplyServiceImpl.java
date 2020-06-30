package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.RepleaseReplyDao;
import com.am.xinlishejiao.modules.sys.entity.RepleaseReplyEntity;
import com.am.xinlishejiao.modules.sys.service.RepleaseReplyService;


@Service("repleaseReplyService")
public class RepleaseReplyServiceImpl extends ServiceImpl<RepleaseReplyDao, RepleaseReplyEntity> implements RepleaseReplyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RepleaseReplyEntity> page = this.page(
                new Query<RepleaseReplyEntity>().getPage(params),
                new QueryWrapper<RepleaseReplyEntity>()
        );

        return new PageUtils(page);
    }

}
