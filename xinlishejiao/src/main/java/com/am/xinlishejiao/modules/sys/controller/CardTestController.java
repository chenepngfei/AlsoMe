package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.CardTestEntity;
import com.am.xinlishejiao.modules.sys.service.CardTestService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 卡片管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:55
 */
@Controller
@RequestMapping("/sys/cardtest")
public class CardTestController {
    @Autowired
    private CardTestService cardTestService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/cardtest";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:cardtest:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = cardTestService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{cardTestId}")
    @ResponseBody
  //  @RequiresPermissions("sys:cardtest:info")
    public Resultful info(@PathVariable("cardTestId") Long cardTestId){
        CardTestEntity cardTest = cardTestService.getById(cardTestId);

        return Resultful.ok().put("cardTest", cardTest);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:cardtest:save")
    public Resultful save(@RequestBody CardTestEntity cardTest){
        cardTestService.save(cardTest);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:cardtest:update")
    public Resultful update(@RequestBody CardTestEntity cardTest){
        ValidatorUtils.validateEntity(cardTest);
        cardTestService.updateById(cardTest);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:cardtest:delete")
    public Resultful delete(@RequestBody Long[] cardTestIds){
        cardTestService.removeByIds(Arrays.asList(cardTestIds));

        return Resultful.ok();
    }

}
