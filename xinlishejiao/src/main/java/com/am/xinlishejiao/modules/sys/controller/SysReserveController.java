package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.SysReserveEntity;
import com.am.xinlishejiao.modules.sys.service.SysReserveService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户预约专家记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:50
 */
@Controller
@RequestMapping("/sys/sysreserve")
public class SysReserveController {
    @Autowired
    private SysReserveService sysReserveService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/sysreserve";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:sysreserve:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = sysReserveService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{reserveId}")
    @ResponseBody
  //  @RequiresPermissions("sys:sysreserve:info")
    public Resultful info(@PathVariable("reserveId") Long reserveId){
        SysReserveEntity sysReserve = sysReserveService.getById(reserveId);

        return Resultful.ok().put("sysReserve", sysReserve);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:sysreserve:save")
    public Resultful save(@RequestBody SysReserveEntity sysReserve){
        sysReserveService.save(sysReserve);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:sysreserve:update")
    public Resultful update(@RequestBody SysReserveEntity sysReserve){
        ValidatorUtils.validateEntity(sysReserve);
        sysReserveService.updateById(sysReserve);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:sysreserve:delete")
    public Resultful delete(@RequestBody Long[] reserveIds){
        sysReserveService.removeByIds(Arrays.asList(reserveIds));

        return Resultful.ok();
    }

}
