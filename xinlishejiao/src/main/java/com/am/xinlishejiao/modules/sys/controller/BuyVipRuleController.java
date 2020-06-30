package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.BuyVipRuleEntity;
import com.am.xinlishejiao.modules.sys.service.BuyVipRuleService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 购买会员规则表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:55
 */
@Controller
@RequestMapping("/sys/buyviprule")
public class BuyVipRuleController {
    @Autowired
    private BuyVipRuleService buyVipRuleService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/buyviprule";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:buyviprule:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = buyVipRuleService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
  //  @RequiresPermissions("sys:buyviprule:info")
    public Resultful info(@PathVariable("id") Long id){
        BuyVipRuleEntity buyVipRule = buyVipRuleService.getById(id);

        return Resultful.ok().put("buyVipRule", buyVipRule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:buyviprule:save")
    public Resultful save(@RequestBody BuyVipRuleEntity buyVipRule){
        buyVipRuleService.save(buyVipRule);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:buyviprule:update")
    public Resultful update(@RequestBody BuyVipRuleEntity buyVipRule){
        ValidatorUtils.validateEntity(buyVipRule);
        buyVipRuleService.updateById(buyVipRule);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:buyviprule:delete")
    public Resultful delete(@RequestBody Long[] ids){
        buyVipRuleService.removeByIds(Arrays.asList(ids));

        return Resultful.ok();
    }

}
