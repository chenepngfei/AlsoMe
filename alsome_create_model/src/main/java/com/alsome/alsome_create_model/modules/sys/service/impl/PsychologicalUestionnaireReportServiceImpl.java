package com.alsome.alsome_create_model.modules.sys.service.impl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;
import com.alsome.alsome_create_model.modules.sys.service.PsychologicalStatusQuestionnaireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.logging.Logger;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alsome.alsome_create_model.modules.sys.dao.PsychologicalUestionnaireReportDao;
import com.alsome.alsome_create_model.modules.sys.entity.PsychologicalUestionnaireReport;
import com.alsome.alsome_create_model.modules.sys.service.PsychologicalUestionnaireReportService;
import org.springframework.transaction.annotation.Transactional;


@Service("psychologicalUestionnaireReportService")
@Slf4j
public class PsychologicalUestionnaireReportServiceImpl extends ServiceImpl<PsychologicalUestionnaireReportDao, PsychologicalUestionnaireReport> implements PsychologicalUestionnaireReportService {

    @Autowired
    PsychologicalStatusQuestionnaireService psychologicalStatusQuestionnaireService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PsychologicalUestionnaireReport> page = this.page(
                new Query<PsychologicalUestionnaireReport>().getPage(params),
                new QueryWrapper<PsychologicalUestionnaireReport>()
        );

        return new PageUtils(page);
    }

}
