package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.UserExaminationResultsEntity;
import com.am.xinlishejiao.modules.sys.service.UserExaminationResultsService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户课程考试结果表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:49
 */
@Controller
@RequestMapping("/sys/userexaminationresults")
public class UserExaminationResultsController {
    @Autowired
    private UserExaminationResultsService userExaminationResultsService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/userexaminationresults";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:userexaminationresults:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = userExaminationResultsService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
  //  @RequiresPermissions("sys:userexaminationresults:info")
    public Resultful info(@PathVariable("id") Long id){
        UserExaminationResultsEntity userExaminationResults = userExaminationResultsService.getById(id);

        return Resultful.ok().put("userExaminationResults", userExaminationResults);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:userexaminationresults:save")
    public Resultful save(@RequestBody UserExaminationResultsEntity userExaminationResults){
        userExaminationResultsService.save(userExaminationResults);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:userexaminationresults:update")
    public Resultful update(@RequestBody UserExaminationResultsEntity userExaminationResults){
        ValidatorUtils.validateEntity(userExaminationResults);
        userExaminationResultsService.updateById(userExaminationResults);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:userexaminationresults:delete")
    public Resultful delete(@RequestBody Long[] ids){
        userExaminationResultsService.removeByIds(Arrays.asList(ids));

        return Resultful.ok();
    }

}
