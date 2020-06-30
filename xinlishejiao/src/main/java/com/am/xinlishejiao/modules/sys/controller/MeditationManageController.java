package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.MeditationManageEntity;
import com.am.xinlishejiao.modules.sys.service.MeditationManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 每日冥想管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:53
 */
@Controller
@RequestMapping("/sys/meditationmanage")
public class MeditationManageController {
    @Autowired
    private MeditationManageService meditationManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/meditationmanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:meditationmanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = meditationManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{meditationId}")
    @ResponseBody
  //  @RequiresPermissions("sys:meditationmanage:info")
    public Resultful info(@PathVariable("meditationId") Long meditationId){
        MeditationManageEntity meditationManage = meditationManageService.getById(meditationId);

        return Resultful.ok().put("meditationManage", meditationManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:meditationmanage:save")
    public Resultful save(@RequestBody MeditationManageEntity meditationManage){
        meditationManageService.save(meditationManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:meditationmanage:update")
    public Resultful update(@RequestBody MeditationManageEntity meditationManage){
        ValidatorUtils.validateEntity(meditationManage);
        meditationManageService.updateById(meditationManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:meditationmanage:delete")
    public Resultful delete(@RequestBody Long[] meditationIds){
        meditationManageService.removeByIds(Arrays.asList(meditationIds));

        return Resultful.ok();
    }

}
