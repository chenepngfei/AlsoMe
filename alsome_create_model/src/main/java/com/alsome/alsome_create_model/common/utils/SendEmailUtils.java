package com.alsome.alsome_create_model.common.utils;

import com.alsome.alsome_create_model.modules.sys.entity.EmailParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * 发送邮件工具类
 * @author
 *
 */
@Component
public class SendEmailUtils {
    private final static Logger logger = LoggerFactory.getLogger(SendEmailUtils.class);


    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;


    /**
     * html模板邮件
     * @param from 发件人
     * @param to 收件人
     * @param subject 邮件主题
     * @param emailParam 给模板的参数
     * @param template html模板路径(相对路径)  Thymeleaf的默认配置期望所有HTML文件都放在 **resources/templates ** 目录下，以.html扩展名结尾。
     * @param imagePath 图片/文件路径(绝对路径)
//     * @throws MessagingException
     */
    public void thymeleafEmail(String from, String[] to, String subject, EmailParam emailParam, String template, String imagePath) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        // 利用 Thymeleaf 模板构建 html 文本
        Context ctx = new Context();
        // 给模板的参数的上下文
        ctx.setVariable("emailParam", emailParam);
        // 执行模板引擎，执行模板引擎需要传入模板名、上下文对象
        // Thymeleaf的默认配置期望所有HTML文件都放在 **resources/templates ** 目录下，以.html扩展名结尾。
        // String emailText = templateEngine.process("email/templates", ctx);
        String emailText = templateEngine.process(template, ctx);
        mimeMessageHelper.setText(emailText, true);
        // FileSystemResource logoImage= new FileSystemResource("D:\\image\\logo.jpg");
        //绝对路径
        FileSystemResource logoImage = new FileSystemResource(imagePath);
        //相对路径，项目的resources路径下
        //ClassPathResource logoImage = new ClassPathResource("static/image/logonew.png");
        // 添加附件,第一个参数表示添加到 Email 中附件的名称，第二个参数是图片资源
        //一般图片调用这个方法
        mimeMessageHelper.addInline("logoImage", logoImage);
        //一般文件附件调用这个方法
//		mimeMessageHelper.addAttachment("logoImage", resource);
        javaMailSender.send(mimeMessage);

    }


    /**
     * html模板邮件
     * @param from 发件人
     * @param to 收件人
     * @param subject 邮件主题
     * @param emailParam 给模板的参数
     * @param template html模板路径(相对路径)  Thymeleaf的默认配置期望所有HTML文件都放在 **resources/templates ** 目录下，以.html扩展名结尾。
    //     * @throws MessagingException
     */
    public void thymeleafSendEmail(String from, String[] to, String subject, EmailParam emailParam, String template) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        // 利用 Thymeleaf 模板构建 html 文本
        Context ctx = new Context();
        // 给模板的参数的上下文
        ctx.setVariable("emailParam", emailParam);
        // 执行模板引擎，执行模板引擎需要传入模板名、上下文对象
        // Thymeleaf的默认配置期望所有HTML文件都放在 **resources/templates ** 目录下，以.html扩展名结尾。
        // String emailText = templateEngine.process("email/templates", ctx);
        String emailText = templateEngine.process(template, ctx);
        mimeMessageHelper.setText(emailText, true);
        // FileSystemResource logoImage= new FileSystemResource("D:\\image\\logo.jpg");
        //一般文件附件调用这个方法
//		mimeMessageHelper.addAttachment("logoImage", resource);
        javaMailSender.send(mimeMessage);

    }

    /**
     * 发送普通邮件
     *
     * @param to      收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendSimpleMailMessge(String to, String subject, String content,String from) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常!", e);
        }
    }

    /**
     *
     * @param context 模板
     * @param templateName 模板名称
     * @param to 收件方
     * @param cc
     * @param subject
     * @param text
     * @param attachmentList
     * @param from
     */
    @Async
    public  void sendEmail(Context context, String templateName, String to, String [] cc,
                          String subject, String text, List<String> attachmentList,String from){
        try {
            // 解决附件名称过长导致的附件名称乱码问题
            System.setProperty("mail.mime.splitlongparameters", "false");
            // 定义邮件信息
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            if(cc != null && cc.length > 0){
                helper.setCc(cc);
            }

            // 如果存在模板，定义邮件模板中的内容，context的内容对应email.html的${project}占位的内容
            if(context != null && StringUtils.isNotBlank(templateName)){
                String emailContent = templateEngine.process(templateName, context);
                helper.setText(emailContent, true);
            }else{
                helper.setText(text);
            }

            // 如果存在附件，定义邮件的附件
            if(attachmentList != null && attachmentList.size() > 0){
                for (String attachment : attachmentList) {
                    FileSystemResource file = new FileSystemResource(attachment);
                    helper.addAttachment(file.getFilename(), file);
                }
            }
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
