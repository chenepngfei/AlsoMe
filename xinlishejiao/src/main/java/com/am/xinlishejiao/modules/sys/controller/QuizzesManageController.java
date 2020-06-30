package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.QuizzesManageEntity;
import com.am.xinlishejiao.modules.sys.service.QuizzesManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 测试题管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:52
 */
@Controller
@RequestMapping("/sys/quizzesmanage")
public class QuizzesManageController {
    @Autowired
    private QuizzesManageService quizzesManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/quizzesmanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:quizzesmanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = quizzesManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{quizzesId}")
    @ResponseBody
  //  @RequiresPermissions("sys:quizzesmanage:info")
    public Resultful info(@PathVariable("quizzesId") Long quizzesId){
        QuizzesManageEntity quizzesManage = quizzesManageService.getById(quizzesId);

        return Resultful.ok().put("quizzesManage", quizzesManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:quizzesmanage:save")
    public Resultful save(@RequestBody QuizzesManageEntity quizzesManage){
        quizzesManageService.save(quizzesManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:quizzesmanage:update")
    public Resultful update(@RequestBody QuizzesManageEntity quizzesManage){
        ValidatorUtils.validateEntity(quizzesManage);
        quizzesManageService.updateById(quizzesManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:quizzesmanage:delete")
    public Resultful delete(@RequestBody Long[] quizzesIds){
        quizzesManageService.removeByIds(Arrays.asList(quizzesIds));

        return Resultful.ok();
    }

}
