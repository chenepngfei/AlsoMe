package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.RepleasePicsEntity;
import com.am.xinlishejiao.modules.sys.service.RepleasePicsService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 想法,树洞图片管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:51
 */
@Controller
@RequestMapping("/sys/repleasepics")
public class RepleasePicsController {
    @Autowired
    private RepleasePicsService repleasePicsService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/repleasepics";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:repleasepics:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = repleasePicsService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{picId}")
    @ResponseBody
  //  @RequiresPermissions("sys:repleasepics:info")
    public Resultful info(@PathVariable("picId") Long picId){
        RepleasePicsEntity repleasePics = repleasePicsService.getById(picId);

        return Resultful.ok().put("repleasePics", repleasePics);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:repleasepics:save")
    public Resultful save(@RequestBody RepleasePicsEntity repleasePics){
        repleasePicsService.save(repleasePics);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:repleasepics:update")
    public Resultful update(@RequestBody RepleasePicsEntity repleasePics){
        ValidatorUtils.validateEntity(repleasePics);
        repleasePicsService.updateById(repleasePics);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:repleasepics:delete")
    public Resultful delete(@RequestBody Long[] picIds){
        repleasePicsService.removeByIds(Arrays.asList(picIds));

        return Resultful.ok();
    }

}
