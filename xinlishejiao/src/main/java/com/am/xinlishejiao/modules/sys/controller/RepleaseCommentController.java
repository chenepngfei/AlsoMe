package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.RepleaseCommentEntity;
import com.am.xinlishejiao.modules.sys.service.RepleaseCommentService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 提问/想法/树洞 /最新资讯评论表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:52
 */
@Controller
@RequestMapping("/sys/repleasecomment")
public class RepleaseCommentController {
    @Autowired
    private RepleaseCommentService repleaseCommentService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/repleasecomment";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:repleasecomment:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = repleaseCommentService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{commentid}")
    @ResponseBody
  //  @RequiresPermissions("sys:repleasecomment:info")
    public Resultful info(@PathVariable("commentid") Long commentid){
        RepleaseCommentEntity repleaseComment = repleaseCommentService.getById(commentid);

        return Resultful.ok().put("repleaseComment", repleaseComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:repleasecomment:save")
    public Resultful save(@RequestBody RepleaseCommentEntity repleaseComment){
        repleaseCommentService.save(repleaseComment);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:repleasecomment:update")
    public Resultful update(@RequestBody RepleaseCommentEntity repleaseComment){
        ValidatorUtils.validateEntity(repleaseComment);
        repleaseCommentService.updateById(repleaseComment);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:repleasecomment:delete")
    public Resultful delete(@RequestBody Long[] commentids){
        repleaseCommentService.removeByIds(Arrays.asList(commentids));

        return Resultful.ok();
    }

}
