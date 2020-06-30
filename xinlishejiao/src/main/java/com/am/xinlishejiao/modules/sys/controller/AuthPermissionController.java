package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.AuthPermissionEntity;
import com.am.xinlishejiao.modules.sys.service.AuthPermissionService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 角色许可表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:56
 */
@Controller
@RequestMapping("/sys/authpermission")
public class AuthPermissionController {
    @Autowired
    private AuthPermissionService authPermissionService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/authpermission";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:authpermission:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = authPermissionService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roleId}")
    @ResponseBody
  //  @RequiresPermissions("sys:authpermission:info")
    public Resultful info(@PathVariable("roleId") Integer roleId){
        AuthPermissionEntity authPermission = authPermissionService.getById(roleId);

        return Resultful.ok().put("authPermission", authPermission);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:authpermission:save")
    public Resultful save(@RequestBody AuthPermissionEntity authPermission){
        authPermissionService.save(authPermission);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:authpermission:update")
    public Resultful update(@RequestBody AuthPermissionEntity authPermission){
        ValidatorUtils.validateEntity(authPermission);
        authPermissionService.updateById(authPermission);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:authpermission:delete")
    public Resultful delete(@RequestBody Integer[] roleIds){
        authPermissionService.removeByIds(Arrays.asList(roleIds));

        return Resultful.ok();
    }

}
