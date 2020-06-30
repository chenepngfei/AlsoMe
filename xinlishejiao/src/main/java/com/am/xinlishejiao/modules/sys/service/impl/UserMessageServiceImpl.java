package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.UserMessageDao;
import com.am.xinlishejiao.modules.sys.entity.UserMessageEntity;
import com.am.xinlishejiao.modules.sys.service.UserMessageService;


@Service("userMessageService")
public class UserMessageServiceImpl extends ServiceImpl<UserMessageDao, UserMessageEntity> implements UserMessageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserMessageEntity> page = this.page(
                new Query<UserMessageEntity>().getPage(params),
                new QueryWrapper<UserMessageEntity>()
        );

        return new PageUtils(page);
    }

}
