package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.AuthAdminEntity;
import com.am.xinlishejiao.modules.sys.service.AuthAdminService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 后台管理员表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:55
 */
@Controller
@RequestMapping("/sys/authadmin")
public class AuthAdminController {
    @Autowired
    private AuthAdminService authAdminService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/authadmin";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:authadmin:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = authAdminService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
  //  @RequiresPermissions("sys:authadmin:info")
    public Resultful info(@PathVariable("id") Integer id){
        AuthAdminEntity authAdmin = authAdminService.getById(id);

        return Resultful.ok().put("authAdmin", authAdmin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:authadmin:save")
    public Resultful save(@RequestBody AuthAdminEntity authAdmin){
        authAdminService.save(authAdmin);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:authadmin:update")
    public Resultful update(@RequestBody AuthAdminEntity authAdmin){
        ValidatorUtils.validateEntity(authAdmin);
        authAdminService.updateById(authAdmin);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:authadmin:delete")
    public Resultful delete(@RequestBody Integer[] ids){
        authAdminService.removeByIds(Arrays.asList(ids));

        return Resultful.ok();
    }

}
