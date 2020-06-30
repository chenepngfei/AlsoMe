package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.MbUserSignEntity;
import com.am.xinlishejiao.modules.sys.service.MbUserSignService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户签到表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:53
 */
@Controller
@RequestMapping("/sys/mbusersign")
public class MbUserSignController {
    @Autowired
    private MbUserSignService mbUserSignService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/mbusersign";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:mbusersign:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = mbUserSignService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{signId}")
    @ResponseBody
  //  @RequiresPermissions("sys:mbusersign:info")
    public Resultful info(@PathVariable("signId") Long signId){
        MbUserSignEntity mbUserSign = mbUserSignService.getById(signId);

        return Resultful.ok().put("mbUserSign", mbUserSign);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:mbusersign:save")
    public Resultful save(@RequestBody MbUserSignEntity mbUserSign){
        mbUserSignService.save(mbUserSign);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:mbusersign:update")
    public Resultful update(@RequestBody MbUserSignEntity mbUserSign){
        ValidatorUtils.validateEntity(mbUserSign);
        mbUserSignService.updateById(mbUserSign);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:mbusersign:delete")
    public Resultful delete(@RequestBody Long[] signIds){
        mbUserSignService.removeByIds(Arrays.asList(signIds));

        return Resultful.ok();
    }

}
