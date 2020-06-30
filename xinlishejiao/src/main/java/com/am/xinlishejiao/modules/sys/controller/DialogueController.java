package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.DialogueEntity;
import com.am.xinlishejiao.modules.sys.service.DialogueService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 提问/想法通用表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:54
 */
@Controller
@RequestMapping("/sys/dialogue")
public class DialogueController {
    @Autowired
    private DialogueService dialogueService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/dialogue";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:dialogue:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = dialogueService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{dialogueId}")
    @ResponseBody
  //  @RequiresPermissions("sys:dialogue:info")
    public Resultful info(@PathVariable("dialogueId") Long dialogueId){
        DialogueEntity dialogue = dialogueService.getById(dialogueId);

        return Resultful.ok().put("dialogue", dialogue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:dialogue:save")
    public Resultful save(@RequestBody DialogueEntity dialogue){
        dialogueService.save(dialogue);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:dialogue:update")
    public Resultful update(@RequestBody DialogueEntity dialogue){
        ValidatorUtils.validateEntity(dialogue);
        dialogueService.updateById(dialogue);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:dialogue:delete")
    public Resultful delete(@RequestBody Long[] dialogueIds){
        dialogueService.removeByIds(Arrays.asList(dialogueIds));

        return Resultful.ok();
    }

}
