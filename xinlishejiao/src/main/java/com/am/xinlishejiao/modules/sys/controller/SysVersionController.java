package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.SysVersionEntity;
import com.am.xinlishejiao.modules.sys.service.SysVersionService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 系统版本管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:50
 */
@Controller
@RequestMapping("/sys/sysversion")
public class SysVersionController {
    @Autowired
    private SysVersionService sysVersionService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/sysversion";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:sysversion:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = sysVersionService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{sysversionid}")
    @ResponseBody
  //  @RequiresPermissions("sys:sysversion:info")
    public Resultful info(@PathVariable("sysversionid") Integer sysversionid){
        SysVersionEntity sysVersion = sysVersionService.getById(sysversionid);

        return Resultful.ok().put("sysVersion", sysVersion);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:sysversion:save")
    public Resultful save(@RequestBody SysVersionEntity sysVersion){
        sysVersionService.save(sysVersion);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:sysversion:update")
    public Resultful update(@RequestBody SysVersionEntity sysVersion){
        ValidatorUtils.validateEntity(sysVersion);
        sysVersionService.updateById(sysVersion);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:sysversion:delete")
    public Resultful delete(@RequestBody Integer[] sysversionids){
        sysVersionService.removeByIds(Arrays.asList(sysversionids));

        return Resultful.ok();
    }

}
