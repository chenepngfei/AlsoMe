package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.UserRechargeEntity;
import com.am.xinlishejiao.modules.sys.service.UserRechargeService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户充值记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:49
 */
@Controller
@RequestMapping("/sys/userrecharge")
public class UserRechargeController {
    @Autowired
    private UserRechargeService userRechargeService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/userrecharge";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:userrecharge:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = userRechargeService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{rechargeId}")
    @ResponseBody
  //  @RequiresPermissions("sys:userrecharge:info")
    public Resultful info(@PathVariable("rechargeId") Long rechargeId){
        UserRechargeEntity userRecharge = userRechargeService.getById(rechargeId);

        return Resultful.ok().put("userRecharge", userRecharge);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:userrecharge:save")
    public Resultful save(@RequestBody UserRechargeEntity userRecharge){
        userRechargeService.save(userRecharge);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:userrecharge:update")
    public Resultful update(@RequestBody UserRechargeEntity userRecharge){
        ValidatorUtils.validateEntity(userRecharge);
        userRechargeService.updateById(userRecharge);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:userrecharge:delete")
    public Resultful delete(@RequestBody Long[] rechargeIds){
        userRechargeService.removeByIds(Arrays.asList(rechargeIds));

        return Resultful.ok();
    }

}
