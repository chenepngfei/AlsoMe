package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.VestManageEntity;
import com.am.xinlishejiao.modules.sys.service.VestManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户马甲表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:49
 */
@Controller
@RequestMapping("/sys/vestmanage")
public class VestManageController {
    @Autowired
    private VestManageService vestManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/vestmanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:vestmanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = vestManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{vestId}")
    @ResponseBody
  //  @RequiresPermissions("sys:vestmanage:info")
    public Resultful info(@PathVariable("vestId") Long vestId){
        VestManageEntity vestManage = vestManageService.getById(vestId);

        return Resultful.ok().put("vestManage", vestManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:vestmanage:save")
    public Resultful save(@RequestBody VestManageEntity vestManage){
        vestManageService.save(vestManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:vestmanage:update")
    public Resultful update(@RequestBody VestManageEntity vestManage){
        ValidatorUtils.validateEntity(vestManage);
        vestManageService.updateById(vestManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:vestmanage:delete")
    public Resultful delete(@RequestBody Long[] vestIds){
        vestManageService.removeByIds(Arrays.asList(vestIds));

        return Resultful.ok();
    }

}
