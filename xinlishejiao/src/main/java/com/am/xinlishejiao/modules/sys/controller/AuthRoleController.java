package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.AuthRoleEntity;
import com.am.xinlishejiao.modules.sys.service.AuthRoleService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 角色表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:55
 */
@Controller
@RequestMapping("/sys/authrole")
public class AuthRoleController {
    @Autowired
    private AuthRoleService authRoleService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/authrole";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:authrole:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = authRoleService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
  //  @RequiresPermissions("sys:authrole:info")
    public Resultful info(@PathVariable("id") Integer id){
        AuthRoleEntity authRole = authRoleService.getById(id);

        return Resultful.ok().put("authRole", authRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:authrole:save")
    public Resultful save(@RequestBody AuthRoleEntity authRole){
        authRoleService.save(authRole);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:authrole:update")
    public Resultful update(@RequestBody AuthRoleEntity authRole){
        ValidatorUtils.validateEntity(authRole);
        authRoleService.updateById(authRole);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:authrole:delete")
    public Resultful delete(@RequestBody Integer[] ids){
        authRoleService.removeByIds(Arrays.asList(ids));

        return Resultful.ok();
    }

}
