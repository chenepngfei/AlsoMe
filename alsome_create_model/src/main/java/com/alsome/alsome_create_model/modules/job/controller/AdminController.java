package com.alsome.alsome_create_model.modules.job.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Slf4j
public class AdminController {

    @RequestMapping("sc")
    public  String schedule(){
        log.info("跳转定时任务页");
        return "modules/job/schedule";
    }


    @RequestMapping("email")
    public  String email(){
        log.info("跳转定时任务页");
        return "index.bak";
    }
}
