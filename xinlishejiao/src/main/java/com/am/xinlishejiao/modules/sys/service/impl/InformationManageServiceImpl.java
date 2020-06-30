package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.InformationManageDao;
import com.am.xinlishejiao.modules.sys.entity.InformationManageEntity;
import com.am.xinlishejiao.modules.sys.service.InformationManageService;


@Service("informationManageService")
public class InformationManageServiceImpl extends ServiceImpl<InformationManageDao, InformationManageEntity> implements InformationManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InformationManageEntity> page = this.page(
                new Query<InformationManageEntity>().getPage(params),
                new QueryWrapper<InformationManageEntity>()
        );

        return new PageUtils(page);
    }

}
