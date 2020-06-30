package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.MbUserEntity;
import com.am.xinlishejiao.modules.sys.service.MbUserService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:53
 */
@Controller
@RequestMapping("/sys/mbuser")
public class MbUserController {
    @Autowired
    private MbUserService mbUserService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/mbuser";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:mbuser:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = mbUserService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @ResponseBody
  //  @RequiresPermissions("sys:mbuser:info")
    public Resultful info(@PathVariable("userId") Long userId){
        MbUserEntity mbUser = mbUserService.getById(userId);

        return Resultful.ok().put("mbUser", mbUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:mbuser:save")
    public Resultful save(@RequestBody MbUserEntity mbUser){
        mbUserService.save(mbUser);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:mbuser:update")
    public Resultful update(@RequestBody MbUserEntity mbUser){
        ValidatorUtils.validateEntity(mbUser);
        mbUserService.updateById(mbUser);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:mbuser:delete")
    public Resultful delete(@RequestBody Long[] userIds){
        mbUserService.removeByIds(Arrays.asList(userIds));

        return Resultful.ok();
    }

}
