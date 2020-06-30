package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.SysMessageEntity;
import com.am.xinlishejiao.modules.sys.service.SysMessageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 系统消息表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:50
 */
@Controller
@RequestMapping("/sys/sysmessage")
public class SysMessageController {
    @Autowired
    private SysMessageService sysMessageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/sysmessage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:sysmessage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = sysMessageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{messageId}")
    @ResponseBody
  //  @RequiresPermissions("sys:sysmessage:info")
    public Resultful info(@PathVariable("messageId") Long messageId){
        SysMessageEntity sysMessage = sysMessageService.getById(messageId);

        return Resultful.ok().put("sysMessage", sysMessage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:sysmessage:save")
    public Resultful save(@RequestBody SysMessageEntity sysMessage){
        sysMessageService.save(sysMessage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:sysmessage:update")
    public Resultful update(@RequestBody SysMessageEntity sysMessage){
        ValidatorUtils.validateEntity(sysMessage);
        sysMessageService.updateById(sysMessage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:sysmessage:delete")
    public Resultful delete(@RequestBody Long[] messageIds){
        sysMessageService.removeByIds(Arrays.asList(messageIds));

        return Resultful.ok();
    }

}
