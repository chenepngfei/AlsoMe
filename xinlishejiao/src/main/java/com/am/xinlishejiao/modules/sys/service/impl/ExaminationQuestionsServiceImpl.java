package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.ExaminationQuestionsDao;
import com.am.xinlishejiao.modules.sys.entity.ExaminationQuestionsEntity;
import com.am.xinlishejiao.modules.sys.service.ExaminationQuestionsService;


@Service("examinationQuestionsService")
public class ExaminationQuestionsServiceImpl extends ServiceImpl<ExaminationQuestionsDao, ExaminationQuestionsEntity> implements ExaminationQuestionsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExaminationQuestionsEntity> page = this.page(
                new Query<ExaminationQuestionsEntity>().getPage(params),
                new QueryWrapper<ExaminationQuestionsEntity>()
        );

        return new PageUtils(page);
    }

}
