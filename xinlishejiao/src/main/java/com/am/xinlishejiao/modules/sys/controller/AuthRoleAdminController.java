package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.AuthRoleAdminEntity;
import com.am.xinlishejiao.modules.sys.service.AuthRoleAdminService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 管理员角色表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:55
 */
@Controller
@RequestMapping("/sys/authroleadmin")
public class AuthRoleAdminController {
    @Autowired
    private AuthRoleAdminService authRoleAdminService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/authroleadmin";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:authroleadmin:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = authRoleAdminService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roleId}")
    @ResponseBody
  //  @RequiresPermissions("sys:authroleadmin:info")
    public Resultful info(@PathVariable("roleId") Integer roleId){
        AuthRoleAdminEntity authRoleAdmin = authRoleAdminService.getById(roleId);

        return Resultful.ok().put("authRoleAdmin", authRoleAdmin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:authroleadmin:save")
    public Resultful save(@RequestBody AuthRoleAdminEntity authRoleAdmin){
        authRoleAdminService.save(authRoleAdmin);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:authroleadmin:update")
    public Resultful update(@RequestBody AuthRoleAdminEntity authRoleAdmin){
        ValidatorUtils.validateEntity(authRoleAdmin);
        authRoleAdminService.updateById(authRoleAdmin);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:authroleadmin:delete")
    public Resultful delete(@RequestBody Integer[] roleIds){
        authRoleAdminService.removeByIds(Arrays.asList(roleIds));

        return Resultful.ok();
    }

}
