package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.UserPossessionEntity;
import com.am.xinlishejiao.modules.sys.service.UserPossessionService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 金币、余额资金变动记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:49
 */
@Controller
@RequestMapping("/sys/userpossession")
public class UserPossessionController {
    @Autowired
    private UserPossessionService userPossessionService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/userpossession";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:userpossession:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = userPossessionService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{recordid}")
    @ResponseBody
  //  @RequiresPermissions("sys:userpossession:info")
    public Resultful info(@PathVariable("recordid") Long recordid){
        UserPossessionEntity userPossession = userPossessionService.getById(recordid);

        return Resultful.ok().put("userPossession", userPossession);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:userpossession:save")
    public Resultful save(@RequestBody UserPossessionEntity userPossession){
        userPossessionService.save(userPossession);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:userpossession:update")
    public Resultful update(@RequestBody UserPossessionEntity userPossession){
        ValidatorUtils.validateEntity(userPossession);
        userPossessionService.updateById(userPossession);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:userpossession:delete")
    public Resultful delete(@RequestBody Long[] recordids){
        userPossessionService.removeByIds(Arrays.asList(recordids));

        return Resultful.ok();
    }

}
