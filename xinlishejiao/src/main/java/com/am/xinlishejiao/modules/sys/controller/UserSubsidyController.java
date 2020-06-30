package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.UserSubsidyEntity;
import com.am.xinlishejiao.modules.sys.service.UserSubsidyService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户津贴设置表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:49
 */
@Controller
@RequestMapping("/sys/usersubsidy")
public class UserSubsidyController {
    @Autowired
    private UserSubsidyService userSubsidyService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/usersubsidy";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:usersubsidy:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = userSubsidyService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userSubsidyId}")
    @ResponseBody
  //  @RequiresPermissions("sys:usersubsidy:info")
    public Resultful info(@PathVariable("userSubsidyId") Long userSubsidyId){
        UserSubsidyEntity userSubsidy = userSubsidyService.getById(userSubsidyId);

        return Resultful.ok().put("userSubsidy", userSubsidy);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:usersubsidy:save")
    public Resultful save(@RequestBody UserSubsidyEntity userSubsidy){
        userSubsidyService.save(userSubsidy);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:usersubsidy:update")
    public Resultful update(@RequestBody UserSubsidyEntity userSubsidy){
        ValidatorUtils.validateEntity(userSubsidy);
        userSubsidyService.updateById(userSubsidy);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:usersubsidy:delete")
    public Resultful delete(@RequestBody Long[] userSubsidyIds){
        userSubsidyService.removeByIds(Arrays.asList(userSubsidyIds));

        return Resultful.ok();
    }

}
