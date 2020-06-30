package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.OrderManagerEntity;
import com.am.xinlishejiao.modules.sys.service.OrderManagerService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 购买会员订单记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:52
 */
@Controller
@RequestMapping("/sys/ordermanager")
public class OrderManagerController {
    @Autowired
    private OrderManagerService orderManagerService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/ordermanager";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:ordermanager:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = orderManagerService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orderId}")
    @ResponseBody
  //  @RequiresPermissions("sys:ordermanager:info")
    public Resultful info(@PathVariable("orderId") Long orderId){
        OrderManagerEntity orderManager = orderManagerService.getById(orderId);

        return Resultful.ok().put("orderManager", orderManager);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:ordermanager:save")
    public Resultful save(@RequestBody OrderManagerEntity orderManager){
        orderManagerService.save(orderManager);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:ordermanager:update")
    public Resultful update(@RequestBody OrderManagerEntity orderManager){
        ValidatorUtils.validateEntity(orderManager);
        orderManagerService.updateById(orderManager);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:ordermanager:delete")
    public Resultful delete(@RequestBody Long[] orderIds){
        orderManagerService.removeByIds(Arrays.asList(orderIds));

        return Resultful.ok();
    }

}
