package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.HelperChargeRuleEntity;
import com.am.xinlishejiao.modules.sys.service.HelperChargeRuleService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * helper收费规则表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:54
 */
@Controller
@RequestMapping("/sys/helperchargerule")
public class HelperChargeRuleController {
    @Autowired
    private HelperChargeRuleService helperChargeRuleService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/helperchargerule";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:helperchargerule:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = helperChargeRuleService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{chargeId}")
    @ResponseBody
  //  @RequiresPermissions("sys:helperchargerule:info")
    public Resultful info(@PathVariable("chargeId") Long chargeId){
        HelperChargeRuleEntity helperChargeRule = helperChargeRuleService.getById(chargeId);

        return Resultful.ok().put("helperChargeRule", helperChargeRule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:helperchargerule:save")
    public Resultful save(@RequestBody HelperChargeRuleEntity helperChargeRule){
        helperChargeRuleService.save(helperChargeRule);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:helperchargerule:update")
    public Resultful update(@RequestBody HelperChargeRuleEntity helperChargeRule){
        ValidatorUtils.validateEntity(helperChargeRule);
        helperChargeRuleService.updateById(helperChargeRule);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:helperchargerule:delete")
    public Resultful delete(@RequestBody Long[] chargeIds){
        helperChargeRuleService.removeByIds(Arrays.asList(chargeIds));

        return Resultful.ok();
    }

}
