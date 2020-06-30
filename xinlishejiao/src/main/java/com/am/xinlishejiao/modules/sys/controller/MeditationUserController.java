package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.MeditationUserEntity;
import com.am.xinlishejiao.modules.sys.service.MeditationUserService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户冥想记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:53
 */
@Controller
@RequestMapping("/sys/meditationuser")
public class MeditationUserController {
    @Autowired
    private MeditationUserService meditationUserService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/meditationuser";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:meditationuser:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = meditationUserService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{meditationUserId}")
    @ResponseBody
  //  @RequiresPermissions("sys:meditationuser:info")
    public Resultful info(@PathVariable("meditationUserId") Long meditationUserId){
        MeditationUserEntity meditationUser = meditationUserService.getById(meditationUserId);

        return Resultful.ok().put("meditationUser", meditationUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:meditationuser:save")
    public Resultful save(@RequestBody MeditationUserEntity meditationUser){
        meditationUserService.save(meditationUser);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:meditationuser:update")
    public Resultful update(@RequestBody MeditationUserEntity meditationUser){
        ValidatorUtils.validateEntity(meditationUser);
        meditationUserService.updateById(meditationUser);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:meditationuser:delete")
    public Resultful delete(@RequestBody Long[] meditationUserIds){
        meditationUserService.removeByIds(Arrays.asList(meditationUserIds));

        return Resultful.ok();
    }

}
