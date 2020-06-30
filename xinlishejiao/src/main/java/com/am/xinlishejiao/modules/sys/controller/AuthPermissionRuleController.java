package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.AuthPermissionRuleEntity;
import com.am.xinlishejiao.modules.sys.service.AuthPermissionRuleService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 角色模块规则表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:55
 */
@Controller
@RequestMapping("/sys/authpermissionrule")
public class AuthPermissionRuleController {
    @Autowired
    private AuthPermissionRuleService authPermissionRuleService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/authpermissionrule";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:authpermissionrule:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = authPermissionRuleService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
  //  @RequiresPermissions("sys:authpermissionrule:info")
    public Resultful info(@PathVariable("id") Integer id){
        AuthPermissionRuleEntity authPermissionRule = authPermissionRuleService.getById(id);

        return Resultful.ok().put("authPermissionRule", authPermissionRule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:authpermissionrule:save")
    public Resultful save(@RequestBody AuthPermissionRuleEntity authPermissionRule){
        authPermissionRuleService.save(authPermissionRule);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:authpermissionrule:update")
    public Resultful update(@RequestBody AuthPermissionRuleEntity authPermissionRule){
        ValidatorUtils.validateEntity(authPermissionRule);
        authPermissionRuleService.updateById(authPermissionRule);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:authpermissionrule:delete")
    public Resultful delete(@RequestBody Integer[] ids){
        authPermissionRuleService.removeByIds(Arrays.asList(ids));

        return Resultful.ok();
    }

}
