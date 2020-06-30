package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.SeekHelpTypeDao;
import com.am.xinlishejiao.modules.sys.entity.SeekHelpTypeEntity;
import com.am.xinlishejiao.modules.sys.service.SeekHelpTypeService;


@Service("seekHelpTypeService")
public class SeekHelpTypeServiceImpl extends ServiceImpl<SeekHelpTypeDao, SeekHelpTypeEntity> implements SeekHelpTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SeekHelpTypeEntity> page = this.page(
                new Query<SeekHelpTypeEntity>().getPage(params),
                new QueryWrapper<SeekHelpTypeEntity>()
        );

        return new PageUtils(page);
    }

}
