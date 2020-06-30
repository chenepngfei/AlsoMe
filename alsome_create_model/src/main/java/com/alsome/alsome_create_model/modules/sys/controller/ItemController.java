package com.alsome.alsome_create_model.modules.sys.controller;

import com.AlsoMe.commons.enums.DepressionPerformanceEnums;
import com.AlsoMe.commons.utils.Resultful;
import com.alsome.alsome_create_model.common.utils.SendEmailUtils;
import com.alsome.alsome_create_model.modules.sys.entity.EmailParam;
import com.alsome.alsome_create_model.modules.sys.entity.PsychologicalUestionnaireReport;
import com.alsome.alsome_create_model.modules.sys.service.PsychologicalUestionnaireReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.collections.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/test")
public class ItemController {

    private final Logger log = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private PsychologicalUestionnaireReportService psychologicalUestionnaireReportService;

    @Value("${spring.mail.username}")
    private String from;
    @Value("${templatePath}")
    private String templatePath;
    @Value("${imagePath}")
    private String imagePath;
    @Autowired
    private SendEmailUtils sendEmailUtils;

    /**
     * email
     * @param itemIds
     * @param response
     */
    @GetMapping(value ="/email", produces = "text/plain;charset=UTF-8")
    public void testEmaili(String itemIds, HttpServletResponse response) {
        try {
            EmailParam emailParam = new EmailParam();
            emailParam.setStuName("张阿牛");
            emailParam.setItemName("亚太银行账目统计");
            emailParam.setUpdateContent("付款到账");
            emailParam.setUpdatePerson("盖茨");
            emailParam.setRemarks("成功到账");
            //此处to数组输入多个值，即可实现批量发送
            String [] to={"674731792@qq.com"};
            sendEmailUtils.thymeleafEmail(from, to, "这是一封测试邮件主题", emailParam, templatePath, imagePath);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @RequestMapping("sendEmail")
    public Resultful sendEmail(){

        try {
            List<PsychologicalUestionnaireReport> list = psychologicalUestionnaireReportService.list();
            if(CollectionUtils.isNotEmpty(list)) {
                for(PsychologicalUestionnaireReport pur : list) {
                    String context = "http://112.126.97.88:8080/#/result?id="+pur.getId()+"&email=" +pur.getEmail();
                    sendEmailUtils.sendSimpleMailMessge(pur.getEmail(),"心理问卷调查",context,from);
                    log.info("用户id：{},邮箱:{},发送成功");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            return  Resultful.error(1,"发送失败");
        }

        return  Resultful.ok();
    }

    public static void main(String[] args) {
        System.out.println(DepressionPerformanceEnums.getDescribeByKey(71));
    }

}
