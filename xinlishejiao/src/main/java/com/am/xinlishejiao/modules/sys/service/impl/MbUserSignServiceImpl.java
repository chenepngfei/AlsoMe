package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.MbUserSignDao;
import com.am.xinlishejiao.modules.sys.entity.MbUserSignEntity;
import com.am.xinlishejiao.modules.sys.service.MbUserSignService;


@Service("mbUserSignService")
public class MbUserSignServiceImpl extends ServiceImpl<MbUserSignDao, MbUserSignEntity> implements MbUserSignService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MbUserSignEntity> page = this.page(
                new Query<MbUserSignEntity>().getPage(params),
                new QueryWrapper<MbUserSignEntity>()
        );

        return new PageUtils(page);
    }

}
