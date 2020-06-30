package com.alsome.alsome_create_model.modules.sys.service;
import com.AlsoMe.commons.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.alsome.alsome_create_model.modules.sys.entity.PsychologicalUestionnaireReport;

import java.util.List;
import java.util.Map;

/**
 * 心理调研问卷结果报告表
 *
 * @author cpf
 * @email chenpfmail@163.com
 * @date 2020-06-13 11:28:54
 */
public interface PsychologicalUestionnaireReportService extends IService<PsychologicalUestionnaireReport> {

    PageUtils queryPage(Map<String, Object> params);


    /**
     * 定时执行发送邮箱方法
     * @param psychologicalUestionnaireReport
     * @return
     */
    List<PsychologicalUestionnaireReport> queryListByEmail(PsychologicalUestionnaireReport psychologicalUestionnaireReport);

    PsychologicalUestionnaireReport getPsychologicalUestionnaireReport(PsychologicalUestionnaireReport psychologicalUestionnaireReport);
}

