package com.alsome.alsome_create_model.modules.sys.service.impl;

import com.alsome.alsome_create_model.modules.sys.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
    @Value("${spring.mail.username}")
    private String from;
    @Value("${templatePath}")
    private String templatePath;
//    @Value("${imagePath}")
//    private String imagePath;


    @Override
    public  void testEmaail(){
//        try {
//            EmailParam emailParam = new EmailParam();
//            emailParam.setStuName("张阿牛");
//            emailParam.setItemName("亚太银行账目统计");
//            emailParam.setUpdateContent("付款到账");
//            emailParam.setUpdatePerson("盖茨");
//            emailParam.setRemarks("成功到账");
//            //此处to数组输入多个值，即可实现批量发送
//            String [] to={"674731792@qq.com"};
//            SendEmailUtils.thymeleafEmail(from, to, "这是一封测试邮件主题", emailParam, templatePath, null);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
}
