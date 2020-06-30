package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.CourseManageEntity;
import com.am.xinlishejiao.modules.sys.service.CourseManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 课程管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:54
 */
@Controller
@RequestMapping("/sys/coursemanage")
public class CourseManageController {
    @Autowired
    private CourseManageService courseManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/coursemanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:coursemanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = courseManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{courseId}")
    @ResponseBody
  //  @RequiresPermissions("sys:coursemanage:info")
    public Resultful info(@PathVariable("courseId") Long courseId){
        CourseManageEntity courseManage = courseManageService.getById(courseId);

        return Resultful.ok().put("courseManage", courseManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:coursemanage:save")
    public Resultful save(@RequestBody CourseManageEntity courseManage){
        courseManageService.save(courseManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:coursemanage:update")
    public Resultful update(@RequestBody CourseManageEntity courseManage){
        ValidatorUtils.validateEntity(courseManage);
        courseManageService.updateById(courseManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:coursemanage:delete")
    public Resultful delete(@RequestBody Long[] courseIds){
        courseManageService.removeByIds(Arrays.asList(courseIds));

        return Resultful.ok();
    }

}
