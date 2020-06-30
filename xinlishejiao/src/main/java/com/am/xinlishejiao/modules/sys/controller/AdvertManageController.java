package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.AdvertManageEntity;
import com.am.xinlishejiao.modules.sys.service.AdvertManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 广告表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:55
 */
@Controller
@RequestMapping("/sys/advertmanage")
public class AdvertManageController {
    @Autowired
    private AdvertManageService advertManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/advertmanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:advertmanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = advertManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{advertId}")
    @ResponseBody
  //  @RequiresPermissions("sys:advertmanage:info")
    public Resultful info(@PathVariable("advertId") Long advertId){
        AdvertManageEntity advertManage = advertManageService.getById(advertId);

        return Resultful.ok().put("advertManage", advertManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:advertmanage:save")
    public Resultful save(@RequestBody AdvertManageEntity advertManage){
        advertManageService.save(advertManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:advertmanage:update")
    public Resultful update(@RequestBody AdvertManageEntity advertManage){
        ValidatorUtils.validateEntity(advertManage);
        advertManageService.updateById(advertManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:advertmanage:delete")
    public Resultful delete(@RequestBody Long[] advertIds){
        advertManageService.removeByIds(Arrays.asList(advertIds));

        return Resultful.ok();
    }

}
