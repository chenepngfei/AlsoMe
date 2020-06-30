package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.CommunityManageEntity;
import com.am.xinlishejiao.modules.sys.service.CommunityManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 社区管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:55
 */
@Controller
@RequestMapping("/sys/communitymanage")
public class CommunityManageController {
    @Autowired
    private CommunityManageService communityManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/communitymanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:communitymanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = communityManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{communityId}")
    @ResponseBody
  //  @RequiresPermissions("sys:communitymanage:info")
    public Resultful info(@PathVariable("communityId") Long communityId){
        CommunityManageEntity communityManage = communityManageService.getById(communityId);

        return Resultful.ok().put("communityManage", communityManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:communitymanage:save")
    public Resultful save(@RequestBody CommunityManageEntity communityManage){
        communityManageService.save(communityManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:communitymanage:update")
    public Resultful update(@RequestBody CommunityManageEntity communityManage){
        ValidatorUtils.validateEntity(communityManage);
        communityManageService.updateById(communityManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:communitymanage:delete")
    public Resultful delete(@RequestBody Long[] communityIds){
        communityManageService.removeByIds(Arrays.asList(communityIds));

        return Resultful.ok();
    }

}
