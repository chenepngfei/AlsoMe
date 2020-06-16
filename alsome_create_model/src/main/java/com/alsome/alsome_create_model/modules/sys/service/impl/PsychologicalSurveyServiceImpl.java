package com.alsome.alsome_create_model.modules.sys.service.impl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;
import com.alsome.alsome_create_model.modules.sys.dao.PsychologicalSurveyDao;
import com.alsome.alsome_create_model.modules.sys.entity.PsychologicalSurvey;
import com.alsome.alsome_create_model.modules.sys.service.PsychologicalSurveyService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service("psychologicalSurveyService")
public class PsychologicalSurveyServiceImpl extends ServiceImpl<PsychologicalSurveyDao, PsychologicalSurvey> implements PsychologicalSurveyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PsychologicalSurvey> page = this.page(
                new Query<PsychologicalSurvey>().getPage(params),
                new QueryWrapper<PsychologicalSurvey>()
        );

        return new PageUtils(page);
    }

}
