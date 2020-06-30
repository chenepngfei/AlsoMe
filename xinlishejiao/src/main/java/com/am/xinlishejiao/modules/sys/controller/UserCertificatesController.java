package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.UserCertificatesEntity;
import com.am.xinlishejiao.modules.sys.service.UserCertificatesService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 专家证件资质表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:49
 */
@Controller
@RequestMapping("/sys/usercertificates")
public class UserCertificatesController {
    @Autowired
    private UserCertificatesService userCertificatesService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/usercertificates";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:usercertificates:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = userCertificatesService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userCertificatesId}")
    @ResponseBody
  //  @RequiresPermissions("sys:usercertificates:info")
    public Resultful info(@PathVariable("userCertificatesId") Long userCertificatesId){
        UserCertificatesEntity userCertificates = userCertificatesService.getById(userCertificatesId);

        return Resultful.ok().put("userCertificates", userCertificates);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:usercertificates:save")
    public Resultful save(@RequestBody UserCertificatesEntity userCertificates){
        userCertificatesService.save(userCertificates);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:usercertificates:update")
    public Resultful update(@RequestBody UserCertificatesEntity userCertificates){
        ValidatorUtils.validateEntity(userCertificates);
        userCertificatesService.updateById(userCertificates);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:usercertificates:delete")
    public Resultful delete(@RequestBody Long[] userCertificatesIds){
        userCertificatesService.removeByIds(Arrays.asList(userCertificatesIds));

        return Resultful.ok();
    }

}
