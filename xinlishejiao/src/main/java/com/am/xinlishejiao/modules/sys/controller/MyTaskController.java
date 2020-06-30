package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.MyTaskEntity;
import com.am.xinlishejiao.modules.sys.service.MyTaskService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户任务表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:52
 */
@Controller
@RequestMapping("/sys/mytask")
public class MyTaskController {
    @Autowired
    private MyTaskService myTaskService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/mytask";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:mytask:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = myTaskService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{myTaskId}")
    @ResponseBody
  //  @RequiresPermissions("sys:mytask:info")
    public Resultful info(@PathVariable("myTaskId") Long myTaskId){
        MyTaskEntity myTask = myTaskService.getById(myTaskId);

        return Resultful.ok().put("myTask", myTask);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:mytask:save")
    public Resultful save(@RequestBody MyTaskEntity myTask){
        myTaskService.save(myTask);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:mytask:update")
    public Resultful update(@RequestBody MyTaskEntity myTask){
        ValidatorUtils.validateEntity(myTask);
        myTaskService.updateById(myTask);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:mytask:delete")
    public Resultful delete(@RequestBody Long[] myTaskIds){
        myTaskService.removeByIds(Arrays.asList(myTaskIds));

        return Resultful.ok();
    }

}
