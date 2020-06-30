package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.FindCommentDao;
import com.am.xinlishejiao.modules.sys.entity.FindCommentEntity;
import com.am.xinlishejiao.modules.sys.service.FindCommentService;


@Service("findCommentService")
public class FindCommentServiceImpl extends ServiceImpl<FindCommentDao, FindCommentEntity> implements FindCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FindCommentEntity> page = this.page(
                new Query<FindCommentEntity>().getPage(params),
                new QueryWrapper<FindCommentEntity>()
        );

        return new PageUtils(page);
    }

}
