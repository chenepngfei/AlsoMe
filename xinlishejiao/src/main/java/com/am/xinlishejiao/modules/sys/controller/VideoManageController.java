package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.VideoManageEntity;
import com.am.xinlishejiao.modules.sys.service.VideoManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 视频管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:48
 */
@Controller
@RequestMapping("/sys/videomanage")
public class VideoManageController {
    @Autowired
    private VideoManageService videoManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/videomanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:videomanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = videoManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{videoId}")
    @ResponseBody
  //  @RequiresPermissions("sys:videomanage:info")
    public Resultful info(@PathVariable("videoId") Long videoId){
        VideoManageEntity videoManage = videoManageService.getById(videoId);

        return Resultful.ok().put("videoManage", videoManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:videomanage:save")
    public Resultful save(@RequestBody VideoManageEntity videoManage){
        videoManageService.save(videoManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:videomanage:update")
    public Resultful update(@RequestBody VideoManageEntity videoManage){
        ValidatorUtils.validateEntity(videoManage);
        videoManageService.updateById(videoManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:videomanage:delete")
    public Resultful delete(@RequestBody Long[] videoIds){
        videoManageService.removeByIds(Arrays.asList(videoIds));

        return Resultful.ok();
    }

}
