package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.CourseChapterEntity;
import com.am.xinlishejiao.modules.sys.service.CourseChapterService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 课程章节表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:54
 */
@Controller
@RequestMapping("/sys/coursechapter")
public class CourseChapterController {
    @Autowired
    private CourseChapterService courseChapterService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/coursechapter";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:coursechapter:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = courseChapterService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{chapterId}")
    @ResponseBody
  //  @RequiresPermissions("sys:coursechapter:info")
    public Resultful info(@PathVariable("chapterId") Long chapterId){
        CourseChapterEntity courseChapter = courseChapterService.getById(chapterId);

        return Resultful.ok().put("courseChapter", courseChapter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:coursechapter:save")
    public Resultful save(@RequestBody CourseChapterEntity courseChapter){
        courseChapterService.save(courseChapter);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:coursechapter:update")
    public Resultful update(@RequestBody CourseChapterEntity courseChapter){
        ValidatorUtils.validateEntity(courseChapter);
        courseChapterService.updateById(courseChapter);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:coursechapter:delete")
    public Resultful delete(@RequestBody Long[] chapterIds){
        courseChapterService.removeByIds(Arrays.asList(chapterIds));

        return Resultful.ok();
    }

}
