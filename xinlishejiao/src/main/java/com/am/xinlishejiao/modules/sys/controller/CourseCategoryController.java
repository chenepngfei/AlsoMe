package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.CourseCategoryEntity;
import com.am.xinlishejiao.modules.sys.service.CourseCategoryService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 课程类别表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:54
 */
@Controller
@RequestMapping("/sys/coursecategory")
public class CourseCategoryController {
    @Autowired
    private CourseCategoryService courseCategoryService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/coursecategory";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:coursecategory:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = courseCategoryService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{courseCategoryId}")
    @ResponseBody
  //  @RequiresPermissions("sys:coursecategory:info")
    public Resultful info(@PathVariable("courseCategoryId") Long courseCategoryId){
        CourseCategoryEntity courseCategory = courseCategoryService.getById(courseCategoryId);

        return Resultful.ok().put("courseCategory", courseCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:coursecategory:save")
    public Resultful save(@RequestBody CourseCategoryEntity courseCategory){
        courseCategoryService.save(courseCategory);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:coursecategory:update")
    public Resultful update(@RequestBody CourseCategoryEntity courseCategory){
        ValidatorUtils.validateEntity(courseCategory);
        courseCategoryService.updateById(courseCategory);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:coursecategory:delete")
    public Resultful delete(@RequestBody Long[] courseCategoryIds){
        courseCategoryService.removeByIds(Arrays.asList(courseCategoryIds));

        return Resultful.ok();
    }

}
