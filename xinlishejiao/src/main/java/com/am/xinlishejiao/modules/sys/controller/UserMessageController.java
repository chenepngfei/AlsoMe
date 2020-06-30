package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.UserMessageEntity;
import com.am.xinlishejiao.modules.sys.service.UserMessageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户消息表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:49
 */
@Controller
@RequestMapping("/sys/usermessage")
public class UserMessageController {
    @Autowired
    private UserMessageService userMessageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/usermessage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:usermessage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = userMessageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userMessageId}")
    @ResponseBody
  //  @RequiresPermissions("sys:usermessage:info")
    public Resultful info(@PathVariable("userMessageId") Long userMessageId){
        UserMessageEntity userMessage = userMessageService.getById(userMessageId);

        return Resultful.ok().put("userMessage", userMessage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:usermessage:save")
    public Resultful save(@RequestBody UserMessageEntity userMessage){
        userMessageService.save(userMessage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:usermessage:update")
    public Resultful update(@RequestBody UserMessageEntity userMessage){
        ValidatorUtils.validateEntity(userMessage);
        userMessageService.updateById(userMessage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:usermessage:delete")
    public Resultful delete(@RequestBody Long[] userMessageIds){
        userMessageService.removeByIds(Arrays.asList(userMessageIds));

        return Resultful.ok();
    }

}
