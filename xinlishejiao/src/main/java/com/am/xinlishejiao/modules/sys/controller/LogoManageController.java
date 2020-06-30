package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.LogoManageEntity;
import com.am.xinlishejiao.modules.sys.service.LogoManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * logo管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:53
 */
@Controller
@RequestMapping("/sys/logomanage")
public class LogoManageController {
    @Autowired
    private LogoManageService logoManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/logomanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:logomanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = logoManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{logoId}")
    @ResponseBody
  //  @RequiresPermissions("sys:logomanage:info")
    public Resultful info(@PathVariable("logoId") Long logoId){
        LogoManageEntity logoManage = logoManageService.getById(logoId);

        return Resultful.ok().put("logoManage", logoManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:logomanage:save")
    public Resultful save(@RequestBody LogoManageEntity logoManage){
        logoManageService.save(logoManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:logomanage:update")
    public Resultful update(@RequestBody LogoManageEntity logoManage){
        ValidatorUtils.validateEntity(logoManage);
        logoManageService.updateById(logoManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:logomanage:delete")
    public Resultful delete(@RequestBody Long[] logoIds){
        logoManageService.removeByIds(Arrays.asList(logoIds));

        return Resultful.ok();
    }

}
