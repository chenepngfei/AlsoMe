package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.RepleaseCommentDao;
import com.am.xinlishejiao.modules.sys.entity.RepleaseCommentEntity;
import com.am.xinlishejiao.modules.sys.service.RepleaseCommentService;


@Service("repleaseCommentService")
public class RepleaseCommentServiceImpl extends ServiceImpl<RepleaseCommentDao, RepleaseCommentEntity> implements RepleaseCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RepleaseCommentEntity> page = this.page(
                new Query<RepleaseCommentEntity>().getPage(params),
                new QueryWrapper<RepleaseCommentEntity>()
        );

        return new PageUtils(page);
    }

}
