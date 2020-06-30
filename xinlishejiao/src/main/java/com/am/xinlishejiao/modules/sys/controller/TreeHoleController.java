package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.TreeHoleEntity;
import com.am.xinlishejiao.modules.sys.service.TreeHoleService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 树洞管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:49
 */
@Controller
@RequestMapping("/sys/treehole")
public class TreeHoleController {
    @Autowired
    private TreeHoleService treeHoleService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/treehole";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:treehole:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = treeHoleService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{treeHoleId}")
    @ResponseBody
  //  @RequiresPermissions("sys:treehole:info")
    public Resultful info(@PathVariable("treeHoleId") Long treeHoleId){
        TreeHoleEntity treeHole = treeHoleService.getById(treeHoleId);

        return Resultful.ok().put("treeHole", treeHole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:treehole:save")
    public Resultful save(@RequestBody TreeHoleEntity treeHole){
        treeHoleService.save(treeHole);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:treehole:update")
    public Resultful update(@RequestBody TreeHoleEntity treeHole){
        ValidatorUtils.validateEntity(treeHole);
        treeHoleService.updateById(treeHole);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:treehole:delete")
    public Resultful delete(@RequestBody Long[] treeHoleIds){
        treeHoleService.removeByIds(Arrays.asList(treeHoleIds));

        return Resultful.ok();
    }

}
