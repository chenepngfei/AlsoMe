package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.MyCourseEntity;
import com.am.xinlishejiao.modules.sys.service.MyCourseService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户购买课程表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:52
 */
@Controller
@RequestMapping("/sys/mycourse")
public class MyCourseController {
    @Autowired
    private MyCourseService myCourseService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/mycourse";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:mycourse:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = myCourseService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{myCourseId}")
    @ResponseBody
  //  @RequiresPermissions("sys:mycourse:info")
    public Resultful info(@PathVariable("myCourseId") Long myCourseId){
        MyCourseEntity myCourse = myCourseService.getById(myCourseId);

        return Resultful.ok().put("myCourse", myCourse);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:mycourse:save")
    public Resultful save(@RequestBody MyCourseEntity myCourse){
        myCourseService.save(myCourse);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:mycourse:update")
    public Resultful update(@RequestBody MyCourseEntity myCourse){
        ValidatorUtils.validateEntity(myCourse);
        myCourseService.updateById(myCourse);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:mycourse:delete")
    public Resultful delete(@RequestBody Long[] myCourseIds){
        myCourseService.removeByIds(Arrays.asList(myCourseIds));

        return Resultful.ok();
    }

}
