package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.ExaminationResultsEntity;
import com.am.xinlishejiao.modules.sys.service.ExaminationResultsService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 试题结果表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:54
 */
@Controller
@RequestMapping("/sys/examinationresults")
public class ExaminationResultsController {
    @Autowired
    private ExaminationResultsService examinationResultsService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/examinationresults";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:examinationresults:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = examinationResultsService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{examinationResultsId}")
    @ResponseBody
  //  @RequiresPermissions("sys:examinationresults:info")
    public Resultful info(@PathVariable("examinationResultsId") Long examinationResultsId){
        ExaminationResultsEntity examinationResults = examinationResultsService.getById(examinationResultsId);

        return Resultful.ok().put("examinationResults", examinationResults);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:examinationresults:save")
    public Resultful save(@RequestBody ExaminationResultsEntity examinationResults){
        examinationResultsService.save(examinationResults);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:examinationresults:update")
    public Resultful update(@RequestBody ExaminationResultsEntity examinationResults){
        ValidatorUtils.validateEntity(examinationResults);
        examinationResultsService.updateById(examinationResults);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:examinationresults:delete")
    public Resultful delete(@RequestBody Long[] examinationResultsIds){
        examinationResultsService.removeByIds(Arrays.asList(examinationResultsIds));

        return Resultful.ok();
    }

}
