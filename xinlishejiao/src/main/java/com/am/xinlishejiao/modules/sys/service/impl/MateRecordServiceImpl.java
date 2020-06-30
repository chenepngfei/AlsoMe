package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.MateRecordDao;
import com.am.xinlishejiao.modules.sys.entity.MateRecordEntity;
import com.am.xinlishejiao.modules.sys.service.MateRecordService;


@Service("mateRecordService")
public class MateRecordServiceImpl extends ServiceImpl<MateRecordDao, MateRecordEntity> implements MateRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MateRecordEntity> page = this.page(
                new Query<MateRecordEntity>().getPage(params),
                new QueryWrapper<MateRecordEntity>()
        );

        return new PageUtils(page);
    }

}
