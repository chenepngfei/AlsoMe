package com.alsome.alsome_create_model.modules.job.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminController {

    @RequestMapping("sc")
    public  String schedule(){
        return "/modules/job/schedule";
    }
}
