package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.CommunityUserEntity;
import com.am.xinlishejiao.modules.sys.service.CommunityUserService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 社区用户表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:55
 */
@Controller
@RequestMapping("/sys/communityuser")
public class CommunityUserController {
    @Autowired
    private CommunityUserService communityUserService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/communityuser";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:communityuser:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = communityUserService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{communityUserId}")
    @ResponseBody
  //  @RequiresPermissions("sys:communityuser:info")
    public Resultful info(@PathVariable("communityUserId") Long communityUserId){
        CommunityUserEntity communityUser = communityUserService.getById(communityUserId);

        return Resultful.ok().put("communityUser", communityUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:communityuser:save")
    public Resultful save(@RequestBody CommunityUserEntity communityUser){
        communityUserService.save(communityUser);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:communityuser:update")
    public Resultful update(@RequestBody CommunityUserEntity communityUser){
        ValidatorUtils.validateEntity(communityUser);
        communityUserService.updateById(communityUser);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:communityuser:delete")
    public Resultful delete(@RequestBody Long[] communityUserIds){
        communityUserService.removeByIds(Arrays.asList(communityUserIds));

        return Resultful.ok();
    }

}
