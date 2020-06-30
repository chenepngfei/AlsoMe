package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.SysKeyWordEntity;
import com.am.xinlishejiao.modules.sys.service.SysKeyWordService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 关键词搜索表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:51
 */
@Controller
@RequestMapping("/sys/syskeyword")
public class SysKeyWordController {
    @Autowired
    private SysKeyWordService sysKeyWordService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/syskeyword";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:syskeyword:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = sysKeyWordService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{keyWordId}")
    @ResponseBody
  //  @RequiresPermissions("sys:syskeyword:info")
    public Resultful info(@PathVariable("keyWordId") Long keyWordId){
        SysKeyWordEntity sysKeyWord = sysKeyWordService.getById(keyWordId);

        return Resultful.ok().put("sysKeyWord", sysKeyWord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:syskeyword:save")
    public Resultful save(@RequestBody SysKeyWordEntity sysKeyWord){
        sysKeyWordService.save(sysKeyWord);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:syskeyword:update")
    public Resultful update(@RequestBody SysKeyWordEntity sysKeyWord){
        ValidatorUtils.validateEntity(sysKeyWord);
        sysKeyWordService.updateById(sysKeyWord);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:syskeyword:delete")
    public Resultful delete(@RequestBody Long[] keyWordIds){
        sysKeyWordService.removeByIds(Arrays.asList(keyWordIds));

        return Resultful.ok();
    }

}
