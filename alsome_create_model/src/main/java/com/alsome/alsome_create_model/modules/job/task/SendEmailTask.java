package com.alsome.alsome_create_model.modules.job.task;

import com.alsome.alsome_create_model.modules.sys.entity.PsychologicalUestionnaireReport;
import com.alsome.alsome_create_model.modules.sys.service.PsychologicalUestionnaireReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("testEmailTask")
public class SendEmailTask implements ITask {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private PsychologicalUestionnaireReportService psychologicalUestionnaireReportService;
    @Override
    public void run(String params) {
        logger.info("发送邮件---start");
        List<PsychologicalUestionnaireReport> list = psychologicalUestionnaireReportService.queryListByEmail(null);

        logger.info("发送邮件---end");
    }
}
