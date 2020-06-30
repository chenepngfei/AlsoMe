package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.InformationTypeEntity;
import com.am.xinlishejiao.modules.sys.service.InformationTypeService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 资讯类别表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:54
 */
@Controller
@RequestMapping("/sys/informationtype")
public class InformationTypeController {
    @Autowired
    private InformationTypeService informationTypeService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/informationtype";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:informationtype:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = informationTypeService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{informationTypeId}")
    @ResponseBody
  //  @RequiresPermissions("sys:informationtype:info")
    public Resultful info(@PathVariable("informationTypeId") Long informationTypeId){
        InformationTypeEntity informationType = informationTypeService.getById(informationTypeId);

        return Resultful.ok().put("informationType", informationType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:informationtype:save")
    public Resultful save(@RequestBody InformationTypeEntity informationType){
        informationTypeService.save(informationType);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:informationtype:update")
    public Resultful update(@RequestBody InformationTypeEntity informationType){
        ValidatorUtils.validateEntity(informationType);
        informationTypeService.updateById(informationType);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:informationtype:delete")
    public Resultful delete(@RequestBody Long[] informationTypeIds){
        informationTypeService.removeByIds(Arrays.asList(informationTypeIds));

        return Resultful.ok();
    }

}
