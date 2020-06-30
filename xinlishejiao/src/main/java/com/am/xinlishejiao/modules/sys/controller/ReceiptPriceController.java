package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.ReceiptPriceEntity;
import com.am.xinlishejiao.modules.sys.service.ReceiptPriceService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * �ӵ����ù����
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:51
 */
@Controller
@RequestMapping("/sys/receiptprice")
public class ReceiptPriceController {
    @Autowired
    private ReceiptPriceService receiptPriceService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/receiptprice";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:receiptprice:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = receiptPriceService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{receiptPriceId}")
    @ResponseBody
  //  @RequiresPermissions("sys:receiptprice:info")
    public Resultful info(@PathVariable("receiptPriceId") Long receiptPriceId){
        ReceiptPriceEntity receiptPrice = receiptPriceService.getById(receiptPriceId);

        return Resultful.ok().put("receiptPrice", receiptPrice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:receiptprice:save")
    public Resultful save(@RequestBody ReceiptPriceEntity receiptPrice){
        receiptPriceService.save(receiptPrice);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:receiptprice:update")
    public Resultful update(@RequestBody ReceiptPriceEntity receiptPrice){
        ValidatorUtils.validateEntity(receiptPrice);
        receiptPriceService.updateById(receiptPrice);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:receiptprice:delete")
    public Resultful delete(@RequestBody Long[] receiptPriceIds){
        receiptPriceService.removeByIds(Arrays.asList(receiptPriceIds));

        return Resultful.ok();
    }

}
