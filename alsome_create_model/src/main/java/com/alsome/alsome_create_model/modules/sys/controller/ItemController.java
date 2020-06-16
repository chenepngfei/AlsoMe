package com.alsome.alsome_create_model.modules.sys.controller;
import com.alsome.alsome_create_model.common.utils.SendEmailUtils;
import com.alsome.alsome_create_model.modules.sys.entity.EmailParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class ItemController {

    private final Logger log = LoggerFactory.getLogger(ItemController.class);

    @Value("${spring.mail.username}")
    private String from;
    @Value("${templatePath}")
    private String templatePath;
//    @Value("${imagePath}")
//    private String imagePath;
    @Autowired
    private SendEmailUtils sendEmailUtils;

    /**
     * email
     * @param itemIds
     * @param response
     */
    @GetMapping(value ="/email", produces = "text/plain;charset=UTF-8")
    public void testEmaili(String itemIds, HttpServletResponse response/*,
			HttpServletRequest request, HttpSession session,
			@RequestHeader("Authorization") String authToken, Principal puser*/) {
        try {
            EmailParam emailParam = new EmailParam();
            emailParam.setStuName("张阿牛");
            emailParam.setItemName("亚太银行账目统计");
            emailParam.setUpdateContent("付款到账");
            emailParam.setUpdatePerson("盖茨");
            emailParam.setRemarks("成功到账");
            //此处to数组输入多个值，即可实现批量发送
            String [] to={"674731792@qq.com"};
            sendEmailUtils.thymeleafEmail(from, to, "这是一封测试邮件主题", emailParam, templatePath, null);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
