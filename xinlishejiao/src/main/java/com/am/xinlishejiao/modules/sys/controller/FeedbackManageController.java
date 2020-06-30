package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.FeedbackManageEntity;
import com.am.xinlishejiao.modules.sys.service.FeedbackManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 反馈管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:53
 */
@Controller
@RequestMapping("/sys/feedbackmanage")
public class FeedbackManageController {
    @Autowired
    private FeedbackManageService feedbackManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/feedbackmanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:feedbackmanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = feedbackManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{feedbackId}")
    @ResponseBody
  //  @RequiresPermissions("sys:feedbackmanage:info")
    public Resultful info(@PathVariable("feedbackId") Long feedbackId){
        FeedbackManageEntity feedbackManage = feedbackManageService.getById(feedbackId);

        return Resultful.ok().put("feedbackManage", feedbackManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:feedbackmanage:save")
    public Resultful save(@RequestBody FeedbackManageEntity feedbackManage){
        feedbackManageService.save(feedbackManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:feedbackmanage:update")
    public Resultful update(@RequestBody FeedbackManageEntity feedbackManage){
        ValidatorUtils.validateEntity(feedbackManage);
        feedbackManageService.updateById(feedbackManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:feedbackmanage:delete")
    public Resultful delete(@RequestBody Long[] feedbackIds){
        feedbackManageService.removeByIds(Arrays.asList(feedbackIds));

        return Resultful.ok();
    }

}
