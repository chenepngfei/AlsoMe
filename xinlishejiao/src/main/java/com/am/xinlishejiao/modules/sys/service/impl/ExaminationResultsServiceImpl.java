package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.ExaminationResultsDao;
import com.am.xinlishejiao.modules.sys.entity.ExaminationResultsEntity;
import com.am.xinlishejiao.modules.sys.service.ExaminationResultsService;


@Service("examinationResultsService")
public class ExaminationResultsServiceImpl extends ServiceImpl<ExaminationResultsDao, ExaminationResultsEntity> implements ExaminationResultsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExaminationResultsEntity> page = this.page(
                new Query<ExaminationResultsEntity>().getPage(params),
                new QueryWrapper<ExaminationResultsEntity>()
        );

        return new PageUtils(page);
    }

}
