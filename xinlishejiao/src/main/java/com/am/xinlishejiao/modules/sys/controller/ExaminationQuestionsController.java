package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.ExaminationQuestionsEntity;
import com.am.xinlishejiao.modules.sys.service.ExaminationQuestionsService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 试题管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:54
 */
@Controller
@RequestMapping("/sys/examinationquestions")
public class ExaminationQuestionsController {
    @Autowired
    private ExaminationQuestionsService examinationQuestionsService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/examinationquestions";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:examinationquestions:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = examinationQuestionsService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{examinationQuestionsId}")
    @ResponseBody
  //  @RequiresPermissions("sys:examinationquestions:info")
    public Resultful info(@PathVariable("examinationQuestionsId") Long examinationQuestionsId){
        ExaminationQuestionsEntity examinationQuestions = examinationQuestionsService.getById(examinationQuestionsId);

        return Resultful.ok().put("examinationQuestions", examinationQuestions);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:examinationquestions:save")
    public Resultful save(@RequestBody ExaminationQuestionsEntity examinationQuestions){
        examinationQuestionsService.save(examinationQuestions);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:examinationquestions:update")
    public Resultful update(@RequestBody ExaminationQuestionsEntity examinationQuestions){
        ValidatorUtils.validateEntity(examinationQuestions);
        examinationQuestionsService.updateById(examinationQuestions);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:examinationquestions:delete")
    public Resultful delete(@RequestBody Long[] examinationQuestionsIds){
        examinationQuestionsService.removeByIds(Arrays.asList(examinationQuestionsIds));

        return Resultful.ok();
    }

}
