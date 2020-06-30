package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.InformationTypeDao;
import com.am.xinlishejiao.modules.sys.entity.InformationTypeEntity;
import com.am.xinlishejiao.modules.sys.service.InformationTypeService;


@Service("informationTypeService")
public class InformationTypeServiceImpl extends ServiceImpl<InformationTypeDao, InformationTypeEntity> implements InformationTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InformationTypeEntity> page = this.page(
                new Query<InformationTypeEntity>().getPage(params),
                new QueryWrapper<InformationTypeEntity>()
        );

        return new PageUtils(page);
    }

}
