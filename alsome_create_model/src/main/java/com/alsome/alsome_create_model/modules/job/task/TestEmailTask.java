package com.alsome.alsome_create_model.modules.job.task;

import com.alsome.alsome_create_model.modules.sys.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component("testEmailTask")
public class TestEmailTask implements ITask {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    EmailService emailService;
    @Override
    public void run(String params) {
        logger.info("发送邮件---start");
        emailService.testEmaail();
        logger.info("发送邮件---end");
    }
}
