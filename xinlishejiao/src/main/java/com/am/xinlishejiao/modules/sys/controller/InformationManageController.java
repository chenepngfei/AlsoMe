package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.InformationManageEntity;
import com.am.xinlishejiao.modules.sys.service.InformationManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 资讯管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:54
 */
@Controller
@RequestMapping("/sys/informationmanage")
public class InformationManageController {
    @Autowired
    private InformationManageService informationManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/informationmanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:informationmanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = informationManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{informationId}")
    @ResponseBody
  //  @RequiresPermissions("sys:informationmanage:info")
    public Resultful info(@PathVariable("informationId") Long informationId){
        InformationManageEntity informationManage = informationManageService.getById(informationId);

        return Resultful.ok().put("informationManage", informationManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:informationmanage:save")
    public Resultful save(@RequestBody InformationManageEntity informationManage){
        informationManageService.save(informationManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:informationmanage:update")
    public Resultful update(@RequestBody InformationManageEntity informationManage){
        ValidatorUtils.validateEntity(informationManage);
        informationManageService.updateById(informationManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:informationmanage:delete")
    public Resultful delete(@RequestBody Long[] informationIds){
        informationManageService.removeByIds(Arrays.asList(informationIds));

        return Resultful.ok();
    }

}
