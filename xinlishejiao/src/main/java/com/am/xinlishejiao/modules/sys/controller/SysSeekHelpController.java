package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.SysSeekHelpEntity;
import com.am.xinlishejiao.modules.sys.service.SysSeekHelpService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 求助管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:51
 */
@Controller
@RequestMapping("/sys/sysseekhelp")
public class SysSeekHelpController {
    @Autowired
    private SysSeekHelpService sysSeekHelpService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/sysseekhelp";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:sysseekhelp:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = sysSeekHelpService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{seekHelpId}")
    @ResponseBody
  //  @RequiresPermissions("sys:sysseekhelp:info")
    public Resultful info(@PathVariable("seekHelpId") Long seekHelpId){
        SysSeekHelpEntity sysSeekHelp = sysSeekHelpService.getById(seekHelpId);

        return Resultful.ok().put("sysSeekHelp", sysSeekHelp);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:sysseekhelp:save")
    public Resultful save(@RequestBody SysSeekHelpEntity sysSeekHelp){
        sysSeekHelpService.save(sysSeekHelp);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:sysseekhelp:update")
    public Resultful update(@RequestBody SysSeekHelpEntity sysSeekHelp){
        ValidatorUtils.validateEntity(sysSeekHelp);
        sysSeekHelpService.updateById(sysSeekHelp);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:sysseekhelp:delete")
    public Resultful delete(@RequestBody Long[] seekHelpIds){
        sysSeekHelpService.removeByIds(Arrays.asList(seekHelpIds));

        return Resultful.ok();
    }

}
