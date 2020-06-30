package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.SeekHelpTypeEntity;
import com.am.xinlishejiao.modules.sys.service.SeekHelpTypeService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 求助类型管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:51
 */
@Controller
@RequestMapping("/sys/seekhelptype")
public class SeekHelpTypeController {
    @Autowired
    private SeekHelpTypeService seekHelpTypeService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/seekhelptype";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:seekhelptype:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = seekHelpTypeService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{seekHelpTypeId}")
    @ResponseBody
  //  @RequiresPermissions("sys:seekhelptype:info")
    public Resultful info(@PathVariable("seekHelpTypeId") Long seekHelpTypeId){
        SeekHelpTypeEntity seekHelpType = seekHelpTypeService.getById(seekHelpTypeId);

        return Resultful.ok().put("seekHelpType", seekHelpType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:seekhelptype:save")
    public Resultful save(@RequestBody SeekHelpTypeEntity seekHelpType){
        seekHelpTypeService.save(seekHelpType);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:seekhelptype:update")
    public Resultful update(@RequestBody SeekHelpTypeEntity seekHelpType){
        ValidatorUtils.validateEntity(seekHelpType);
        seekHelpTypeService.updateById(seekHelpType);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:seekhelptype:delete")
    public Resultful delete(@RequestBody Long[] seekHelpTypeIds){
        seekHelpTypeService.removeByIds(Arrays.asList(seekHelpTypeIds));

        return Resultful.ok();
    }

}
