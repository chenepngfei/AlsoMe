package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.UserCertificatesDao;
import com.am.xinlishejiao.modules.sys.entity.UserCertificatesEntity;
import com.am.xinlishejiao.modules.sys.service.UserCertificatesService;


@Service("userCertificatesService")
public class UserCertificatesServiceImpl extends ServiceImpl<UserCertificatesDao, UserCertificatesEntity> implements UserCertificatesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserCertificatesEntity> page = this.page(
                new Query<UserCertificatesEntity>().getPage(params),
                new QueryWrapper<UserCertificatesEntity>()
        );

        return new PageUtils(page);
    }

}
