package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.MateManageEntity;
import com.am.xinlishejiao.modules.sys.service.MateManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 匹配设置表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:52
 */
@Controller
@RequestMapping("/sys/matemanage")
public class MateManageController {
    @Autowired
    private MateManageService mateManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/matemanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:matemanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = mateManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{mateId}")
    @ResponseBody
  //  @RequiresPermissions("sys:matemanage:info")
    public Resultful info(@PathVariable("mateId") Long mateId){
        MateManageEntity mateManage = mateManageService.getById(mateId);

        return Resultful.ok().put("mateManage", mateManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:matemanage:save")
    public Resultful save(@RequestBody MateManageEntity mateManage){
        mateManageService.save(mateManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:matemanage:update")
    public Resultful update(@RequestBody MateManageEntity mateManage){
        ValidatorUtils.validateEntity(mateManage);
        mateManageService.updateById(mateManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:matemanage:delete")
    public Resultful delete(@RequestBody Long[] mateIds){
        mateManageService.removeByIds(Arrays.asList(mateIds));

        return Resultful.ok();
    }

}
