package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.FindCommentEntity;
import com.am.xinlishejiao.modules.sys.service.FindCommentService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 课程/广播/视频评论表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:53
 */
@Controller
@RequestMapping("/sys/findcomment")
public class FindCommentController {
    @Autowired
    private FindCommentService findCommentService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/findcomment";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:findcomment:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = findCommentService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{findCommentId}")
    @ResponseBody
  //  @RequiresPermissions("sys:findcomment:info")
    public Resultful info(@PathVariable("findCommentId") Long findCommentId){
        FindCommentEntity findComment = findCommentService.getById(findCommentId);

        return Resultful.ok().put("findComment", findComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:findcomment:save")
    public Resultful save(@RequestBody FindCommentEntity findComment){
        findCommentService.save(findComment);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:findcomment:update")
    public Resultful update(@RequestBody FindCommentEntity findComment){
        ValidatorUtils.validateEntity(findComment);
        findCommentService.updateById(findComment);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:findcomment:delete")
    public Resultful delete(@RequestBody Long[] findCommentIds){
        findCommentService.removeByIds(Arrays.asList(findCommentIds));

        return Resultful.ok();
    }

}
