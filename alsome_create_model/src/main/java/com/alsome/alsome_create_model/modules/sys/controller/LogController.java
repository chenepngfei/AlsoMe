package com.alsome.alsome_create_model.modules.sys.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @ProjectName: logdemo
 * @Package: com.logs.controller
 * @ClassName: LogController
 * @Author: dong
 * @Description: ${description}
 * @Date: 2019/9/4 22:39
 * @Version: 1.0
 */
@Controller
public class LogController {
    private Logger logger = LoggerFactory.getLogger(LogController.class);
    @RequestMapping("/log")
    public void log(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //1.获取请求参数
        String qs = request.getQueryString();
        //2.对URL解码
        String decode = URLDecoder.decode(qs, "utf-8");
        //3.转换成需要处理的格式
        StringBuilder sb = new StringBuilder();
        String[] attrs = decode.split("&");
        for (String attr : attrs) {
            String[] kv = attr.split("=");
            String val = kv.length >= 2 ? kv[1] : "";
            sb.append(val+"|");
        }
        sb.append(request.getRemoteAddr());
        String logStr = sb.toString();
//        System.out.println(logStr);
        logger.info(logStr);
    }
}