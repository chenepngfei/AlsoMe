package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.UserCommentDao;
import com.am.xinlishejiao.modules.sys.entity.UserCommentEntity;
import com.am.xinlishejiao.modules.sys.service.UserCommentService;


@Service("userCommentService")
public class UserCommentServiceImpl extends ServiceImpl<UserCommentDao, UserCommentEntity> implements UserCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserCommentEntity> page = this.page(
                new Query<UserCommentEntity>().getPage(params),
                new QueryWrapper<UserCommentEntity>()
        );

        return new PageUtils(page);
    }

}
