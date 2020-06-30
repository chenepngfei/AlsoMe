package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.TaskManageEntity;
import com.am.xinlishejiao.modules.sys.service.TaskManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 任务管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:50
 */
@Controller
@RequestMapping("/sys/taskmanage")
public class TaskManageController {
    @Autowired
    private TaskManageService taskManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/taskmanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:taskmanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = taskManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{taskId}")
    @ResponseBody
  //  @RequiresPermissions("sys:taskmanage:info")
    public Resultful info(@PathVariable("taskId") Long taskId){
        TaskManageEntity taskManage = taskManageService.getById(taskId);

        return Resultful.ok().put("taskManage", taskManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:taskmanage:save")
    public Resultful save(@RequestBody TaskManageEntity taskManage){
        taskManageService.save(taskManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:taskmanage:update")
    public Resultful update(@RequestBody TaskManageEntity taskManage){
        ValidatorUtils.validateEntity(taskManage);
        taskManageService.updateById(taskManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:taskmanage:delete")
    public Resultful delete(@RequestBody Long[] taskIds){
        taskManageService.removeByIds(Arrays.asList(taskIds));

        return Resultful.ok();
    }

}
