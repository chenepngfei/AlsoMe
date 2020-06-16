package com.alsome.alsome_create_model.modules.sys.controller;
import com.AlsoMe.commons.utils.VerifyCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class VerifyCodeController {
    private  static final Logger log = LoggerFactory.getLogger(VerifyCodeController.class);

    /**
     * 验证码的生成
     * @param request
     * @param response
     */
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        try {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            String code = VerifyCodeUtils.generate(80, 28, baos);
            //设置长宽
            log.info(code);
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(baos.toByteArray());
            response.getOutputStream().flush();
        } catch (IOException e) {
            log.info("", e);
        }
    }



}

