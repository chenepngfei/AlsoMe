package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.FollowManageEntity;
import com.am.xinlishejiao.modules.sys.service.FollowManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户关注表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:54
 */
@Controller
@RequestMapping("/sys/followmanage")
public class FollowManageController {
    @Autowired
    private FollowManageService followManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/followmanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:followmanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = followManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{followManageId}")
    @ResponseBody
  //  @RequiresPermissions("sys:followmanage:info")
    public Resultful info(@PathVariable("followManageId") Long followManageId){
        FollowManageEntity followManage = followManageService.getById(followManageId);

        return Resultful.ok().put("followManage", followManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:followmanage:save")
    public Resultful save(@RequestBody FollowManageEntity followManage){
        followManageService.save(followManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:followmanage:update")
    public Resultful update(@RequestBody FollowManageEntity followManage){
        ValidatorUtils.validateEntity(followManage);
        followManageService.updateById(followManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:followmanage:delete")
    public Resultful delete(@RequestBody Long[] followManageIds){
        followManageService.removeByIds(Arrays.asList(followManageIds));

        return Resultful.ok();
    }

}
