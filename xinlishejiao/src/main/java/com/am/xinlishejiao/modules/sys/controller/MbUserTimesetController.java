package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.MbUserTimesetEntity;
import com.am.xinlishejiao.modules.sys.service.MbUserTimesetService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * helper预约时间设置
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:53
 */
@Controller
@RequestMapping("/sys/mbusertimeset")
public class MbUserTimesetController {
    @Autowired
    private MbUserTimesetService mbUserTimesetService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/mbusertimeset";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:mbusertimeset:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = mbUserTimesetService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{setid}")
    @ResponseBody
  //  @RequiresPermissions("sys:mbusertimeset:info")
    public Resultful info(@PathVariable("setid") Integer setid){
        MbUserTimesetEntity mbUserTimeset = mbUserTimesetService.getById(setid);

        return Resultful.ok().put("mbUserTimeset", mbUserTimeset);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:mbusertimeset:save")
    public Resultful save(@RequestBody MbUserTimesetEntity mbUserTimeset){
        mbUserTimesetService.save(mbUserTimeset);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:mbusertimeset:update")
    public Resultful update(@RequestBody MbUserTimesetEntity mbUserTimeset){
        ValidatorUtils.validateEntity(mbUserTimeset);
        mbUserTimesetService.updateById(mbUserTimeset);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:mbusertimeset:delete")
    public Resultful delete(@RequestBody Integer[] setids){
        mbUserTimesetService.removeByIds(Arrays.asList(setids));

        return Resultful.ok();
    }

}
