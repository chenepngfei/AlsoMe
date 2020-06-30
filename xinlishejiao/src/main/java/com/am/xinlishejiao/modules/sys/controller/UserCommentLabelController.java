package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.UserCommentLabelEntity;
import com.am.xinlishejiao.modules.sys.service.UserCommentLabelService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户评论标签表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:49
 */
@Controller
@RequestMapping("/sys/usercommentlabel")
public class UserCommentLabelController {
    @Autowired
    private UserCommentLabelService userCommentLabelService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/usercommentlabel";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:usercommentlabel:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = userCommentLabelService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
  //  @RequiresPermissions("sys:usercommentlabel:info")
    public Resultful info(@PathVariable("id") Long id){
        UserCommentLabelEntity userCommentLabel = userCommentLabelService.getById(id);

        return Resultful.ok().put("userCommentLabel", userCommentLabel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:usercommentlabel:save")
    public Resultful save(@RequestBody UserCommentLabelEntity userCommentLabel){
        userCommentLabelService.save(userCommentLabel);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:usercommentlabel:update")
    public Resultful update(@RequestBody UserCommentLabelEntity userCommentLabel){
        ValidatorUtils.validateEntity(userCommentLabel);
        userCommentLabelService.updateById(userCommentLabel);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:usercommentlabel:delete")
    public Resultful delete(@RequestBody Long[] ids){
        userCommentLabelService.removeByIds(Arrays.asList(ids));

        return Resultful.ok();
    }

}
