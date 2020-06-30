package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.UserExaminationResultsPicEntity;
import com.am.xinlishejiao.modules.sys.service.UserExaminationResultsPicService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户课程考试结果图片表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:49
 */
@Controller
@RequestMapping("/sys/userexaminationresultspic")
public class UserExaminationResultsPicController {
    @Autowired
    private UserExaminationResultsPicService userExaminationResultsPicService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/userexaminationresultspic";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:userexaminationresultspic:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = userExaminationResultsPicService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
  //  @RequiresPermissions("sys:userexaminationresultspic:info")
    public Resultful info(@PathVariable("id") Long id){
        UserExaminationResultsPicEntity userExaminationResultsPic = userExaminationResultsPicService.getById(id);

        return Resultful.ok().put("userExaminationResultsPic", userExaminationResultsPic);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:userexaminationresultspic:save")
    public Resultful save(@RequestBody UserExaminationResultsPicEntity userExaminationResultsPic){
        userExaminationResultsPicService.save(userExaminationResultsPic);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:userexaminationresultspic:update")
    public Resultful update(@RequestBody UserExaminationResultsPicEntity userExaminationResultsPic){
        ValidatorUtils.validateEntity(userExaminationResultsPic);
        userExaminationResultsPicService.updateById(userExaminationResultsPic);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:userexaminationresultspic:delete")
    public Resultful delete(@RequestBody Long[] ids){
        userExaminationResultsPicService.removeByIds(Arrays.asList(ids));

        return Resultful.ok();
    }

}
