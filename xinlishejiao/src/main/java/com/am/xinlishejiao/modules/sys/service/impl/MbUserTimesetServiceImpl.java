package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.MbUserTimesetDao;
import com.am.xinlishejiao.modules.sys.entity.MbUserTimesetEntity;
import com.am.xinlishejiao.modules.sys.service.MbUserTimesetService;


@Service("mbUserTimesetService")
public class MbUserTimesetServiceImpl extends ServiceImpl<MbUserTimesetDao, MbUserTimesetEntity> implements MbUserTimesetService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MbUserTimesetEntity> page = this.page(
                new Query<MbUserTimesetEntity>().getPage(params),
                new QueryWrapper<MbUserTimesetEntity>()
        );

        return new PageUtils(page);
    }

}
