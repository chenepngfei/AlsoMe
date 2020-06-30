package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.RepleaseReplyEntity;
import com.am.xinlishejiao.modules.sys.service.RepleaseReplyService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 站内评论回复表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:51
 */
@Controller
@RequestMapping("/sys/repleasereply")
public class RepleaseReplyController {
    @Autowired
    private RepleaseReplyService repleaseReplyService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/repleasereply";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:repleasereply:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = repleaseReplyService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{replyid}")
    @ResponseBody
  //  @RequiresPermissions("sys:repleasereply:info")
    public Resultful info(@PathVariable("replyid") Long replyid){
        RepleaseReplyEntity repleaseReply = repleaseReplyService.getById(replyid);

        return Resultful.ok().put("repleaseReply", repleaseReply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:repleasereply:save")
    public Resultful save(@RequestBody RepleaseReplyEntity repleaseReply){
        repleaseReplyService.save(repleaseReply);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:repleasereply:update")
    public Resultful update(@RequestBody RepleaseReplyEntity repleaseReply){
        ValidatorUtils.validateEntity(repleaseReply);
        repleaseReplyService.updateById(repleaseReply);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:repleasereply:delete")
    public Resultful delete(@RequestBody Long[] replyids){
        repleaseReplyService.removeByIds(Arrays.asList(replyids));

        return Resultful.ok();
    }

}
