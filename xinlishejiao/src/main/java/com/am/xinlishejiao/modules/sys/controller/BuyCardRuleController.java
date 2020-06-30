package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.BuyCardRuleEntity;
import com.am.xinlishejiao.modules.sys.service.BuyCardRuleService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 每日卡片抽取次数/匹配次数规则表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:55
 */
@Controller
@RequestMapping("/sys/buycardrule")
public class BuyCardRuleController {
    @Autowired
    private BuyCardRuleService buyCardRuleService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/buycardrule";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:buycardrule:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = buyCardRuleService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
  //  @RequiresPermissions("sys:buycardrule:info")
    public Resultful info(@PathVariable("id") Long id){
        BuyCardRuleEntity buyCardRule = buyCardRuleService.getById(id);

        return Resultful.ok().put("buyCardRule", buyCardRule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:buycardrule:save")
    public Resultful save(@RequestBody BuyCardRuleEntity buyCardRule){
        buyCardRuleService.save(buyCardRule);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:buycardrule:update")
    public Resultful update(@RequestBody BuyCardRuleEntity buyCardRule){
        ValidatorUtils.validateEntity(buyCardRule);
        buyCardRuleService.updateById(buyCardRule);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:buycardrule:delete")
    public Resultful delete(@RequestBody Long[] ids){
        buyCardRuleService.removeByIds(Arrays.asList(ids));

        return Resultful.ok();
    }

}
