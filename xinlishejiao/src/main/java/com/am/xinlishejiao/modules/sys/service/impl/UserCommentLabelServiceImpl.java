package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.UserCommentLabelDao;
import com.am.xinlishejiao.modules.sys.entity.UserCommentLabelEntity;
import com.am.xinlishejiao.modules.sys.service.UserCommentLabelService;


@Service("userCommentLabelService")
public class UserCommentLabelServiceImpl extends ServiceImpl<UserCommentLabelDao, UserCommentLabelEntity> implements UserCommentLabelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserCommentLabelEntity> page = this.page(
                new Query<UserCommentLabelEntity>().getPage(params),
                new QueryWrapper<UserCommentLabelEntity>()
        );

        return new PageUtils(page);
    }

}
