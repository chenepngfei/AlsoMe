package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.ToLocationEntity;
import com.am.xinlishejiao.modules.sys.service.ToLocationService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 全球地区库，采集自腾讯QQ国内+国际版.ADD.JENA.20141221
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:50
 */
@Controller
@RequestMapping("/sys/tolocation")
public class ToLocationController {
    @Autowired
    private ToLocationService toLocationService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/tolocation";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:tolocation:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = toLocationService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
  //  @RequiresPermissions("sys:tolocation:info")
    public Resultful info(@PathVariable("id") Integer id){
        ToLocationEntity toLocation = toLocationService.getById(id);

        return Resultful.ok().put("toLocation", toLocation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:tolocation:save")
    public Resultful save(@RequestBody ToLocationEntity toLocation){
        toLocationService.save(toLocation);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:tolocation:update")
    public Resultful update(@RequestBody ToLocationEntity toLocation){
        ValidatorUtils.validateEntity(toLocation);
        toLocationService.updateById(toLocation);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:tolocation:delete")
    public Resultful delete(@RequestBody Integer[] ids){
        toLocationService.removeByIds(Arrays.asList(ids));

        return Resultful.ok();
    }

}
