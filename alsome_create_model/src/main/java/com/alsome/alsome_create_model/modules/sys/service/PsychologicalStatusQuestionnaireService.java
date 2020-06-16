package com.alsome.alsome_create_model.modules.sys.service;
import com.AlsoMe.commons.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.alsome.alsome_create_model.modules.sys.entity.PsychologicalStatusQuestionnaire;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 中国大学生心理状态调查问卷
 *
 * @author cpf
 * @email chenpfmail@163.com
 * @date 2020-06-13 11:28:54
 */
public interface PsychologicalStatusQuestionnaireService extends IService<PsychologicalStatusQuestionnaire> {

    PageUtils queryPage(Map<String, Object> params);

    @Transactional
    Long createReport(String jsonstr);
}

