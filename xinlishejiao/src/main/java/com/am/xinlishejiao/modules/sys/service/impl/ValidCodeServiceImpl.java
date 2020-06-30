package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.ValidCodeDao;
import com.am.xinlishejiao.modules.sys.entity.ValidCodeEntity;
import com.am.xinlishejiao.modules.sys.service.ValidCodeService;


@Service("validCodeService")
public class ValidCodeServiceImpl extends ServiceImpl<ValidCodeDao, ValidCodeEntity> implements ValidCodeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ValidCodeEntity> page = this.page(
                new Query<ValidCodeEntity>().getPage(params),
                new QueryWrapper<ValidCodeEntity>()
        );

        return new PageUtils(page);
    }

}
