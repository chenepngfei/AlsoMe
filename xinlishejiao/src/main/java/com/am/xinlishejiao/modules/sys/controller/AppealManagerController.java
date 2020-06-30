package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.AppealManagerEntity;
import com.am.xinlishejiao.modules.sys.service.AppealManagerService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 申诉表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:55
 */
@Controller
@RequestMapping("/sys/appealmanager")
public class AppealManagerController {
    @Autowired
    private AppealManagerService appealManagerService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/appealmanager";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:appealmanager:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = appealManagerService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{appealId}")
    @ResponseBody
  //  @RequiresPermissions("sys:appealmanager:info")
    public Resultful info(@PathVariable("appealId") Long appealId){
        AppealManagerEntity appealManager = appealManagerService.getById(appealId);

        return Resultful.ok().put("appealManager", appealManager);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:appealmanager:save")
    public Resultful save(@RequestBody AppealManagerEntity appealManager){
        appealManagerService.save(appealManager);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:appealmanager:update")
    public Resultful update(@RequestBody AppealManagerEntity appealManager){
        ValidatorUtils.validateEntity(appealManager);
        appealManagerService.updateById(appealManager);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:appealmanager:delete")
    public Resultful delete(@RequestBody Long[] appealIds){
        appealManagerService.removeByIds(Arrays.asList(appealIds));

        return Resultful.ok();
    }

}
