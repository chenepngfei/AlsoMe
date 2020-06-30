package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.MbUserDao;
import com.am.xinlishejiao.modules.sys.entity.MbUserEntity;
import com.am.xinlishejiao.modules.sys.service.MbUserService;


@Service("mbUserService")
public class MbUserServiceImpl extends ServiceImpl<MbUserDao, MbUserEntity> implements MbUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MbUserEntity> page = this.page(
                new Query<MbUserEntity>().getPage(params),
                new QueryWrapper<MbUserEntity>()
        );

        return new PageUtils(page);
    }

}
