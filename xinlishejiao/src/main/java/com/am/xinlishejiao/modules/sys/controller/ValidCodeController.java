package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.ValidCodeEntity;
import com.am.xinlishejiao.modules.sys.service.ValidCodeService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 验证码表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:49
 */
@Controller
@RequestMapping("/sys/validcode")
public class ValidCodeController {
    @Autowired
    private ValidCodeService validCodeService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/validcode";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:validcode:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = validCodeService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{validCodeId}")
    @ResponseBody
  //  @RequiresPermissions("sys:validcode:info")
    public Resultful info(@PathVariable("validCodeId") Long validCodeId){
        ValidCodeEntity validCode = validCodeService.getById(validCodeId);

        return Resultful.ok().put("validCode", validCode);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:validcode:save")
    public Resultful save(@RequestBody ValidCodeEntity validCode){
        validCodeService.save(validCode);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:validcode:update")
    public Resultful update(@RequestBody ValidCodeEntity validCode){
        ValidatorUtils.validateEntity(validCode);
        validCodeService.updateById(validCode);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:validcode:delete")
    public Resultful delete(@RequestBody Long[] validCodeIds){
        validCodeService.removeByIds(Arrays.asList(validCodeIds));

        return Resultful.ok();
    }

}
