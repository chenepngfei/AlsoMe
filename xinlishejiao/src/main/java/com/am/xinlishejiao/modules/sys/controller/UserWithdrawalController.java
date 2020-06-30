package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.UserWithdrawalEntity;
import com.am.xinlishejiao.modules.sys.service.UserWithdrawalService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户提现记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:49
 */
@Controller
@RequestMapping("/sys/userwithdrawal")
public class UserWithdrawalController {
    @Autowired
    private UserWithdrawalService userWithdrawalService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/userwithdrawal";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:userwithdrawal:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = userWithdrawalService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{rechargeId}")
    @ResponseBody
  //  @RequiresPermissions("sys:userwithdrawal:info")
    public Resultful info(@PathVariable("rechargeId") Long rechargeId){
        UserWithdrawalEntity userWithdrawal = userWithdrawalService.getById(rechargeId);

        return Resultful.ok().put("userWithdrawal", userWithdrawal);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:userwithdrawal:save")
    public Resultful save(@RequestBody UserWithdrawalEntity userWithdrawal){
        userWithdrawalService.save(userWithdrawal);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:userwithdrawal:update")
    public Resultful update(@RequestBody UserWithdrawalEntity userWithdrawal){
        ValidatorUtils.validateEntity(userWithdrawal);
        userWithdrawalService.updateById(userWithdrawal);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:userwithdrawal:delete")
    public Resultful delete(@RequestBody Long[] rechargeIds){
        userWithdrawalService.removeByIds(Arrays.asList(rechargeIds));

        return Resultful.ok();
    }

}
