package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.UserCommentEntity;
import com.am.xinlishejiao.modules.sys.service.UserCommentService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 评论用户表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:49
 */
@Controller
@RequestMapping("/sys/usercomment")
public class UserCommentController {
    @Autowired
    private UserCommentService userCommentService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/usercomment";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:usercomment:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = userCommentService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userCommentId}")
    @ResponseBody
  //  @RequiresPermissions("sys:usercomment:info")
    public Resultful info(@PathVariable("userCommentId") Long userCommentId){
        UserCommentEntity userComment = userCommentService.getById(userCommentId);

        return Resultful.ok().put("userComment", userComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:usercomment:save")
    public Resultful save(@RequestBody UserCommentEntity userComment){
        userCommentService.save(userComment);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:usercomment:update")
    public Resultful update(@RequestBody UserCommentEntity userComment){
        ValidatorUtils.validateEntity(userComment);
        userCommentService.updateById(userComment);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:usercomment:delete")
    public Resultful delete(@RequestBody Long[] userCommentIds){
        userCommentService.removeByIds(Arrays.asList(userCommentIds));

        return Resultful.ok();
    }

}
