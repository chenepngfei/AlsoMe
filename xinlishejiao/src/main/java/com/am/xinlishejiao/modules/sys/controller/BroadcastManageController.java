package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.BroadcastManageEntity;
import com.am.xinlishejiao.modules.sys.service.BroadcastManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 每日广播表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:55
 */
@Controller
@RequestMapping("/sys/broadcastmanage")
public class BroadcastManageController {
    @Autowired
    private BroadcastManageService broadcastManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/broadcastmanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:broadcastmanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = broadcastManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{broadcastId}")
    @ResponseBody
  //  @RequiresPermissions("sys:broadcastmanage:info")
    public Resultful info(@PathVariable("broadcastId") Long broadcastId){
        BroadcastManageEntity broadcastManage = broadcastManageService.getById(broadcastId);

        return Resultful.ok().put("broadcastManage", broadcastManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:broadcastmanage:save")
    public Resultful save(@RequestBody BroadcastManageEntity broadcastManage){
        broadcastManageService.save(broadcastManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:broadcastmanage:update")
    public Resultful update(@RequestBody BroadcastManageEntity broadcastManage){
        ValidatorUtils.validateEntity(broadcastManage);
        broadcastManageService.updateById(broadcastManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:broadcastmanage:delete")
    public Resultful delete(@RequestBody Long[] broadcastIds){
        broadcastManageService.removeByIds(Arrays.asList(broadcastIds));

        return Resultful.ok();
    }

}
