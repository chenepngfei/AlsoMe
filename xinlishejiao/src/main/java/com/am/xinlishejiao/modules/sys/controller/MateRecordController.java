package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.MateRecordEntity;
import com.am.xinlishejiao.modules.sys.service.MateRecordService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 匹配记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:52
 */
@Controller
@RequestMapping("/sys/materecord")
public class MateRecordController {
    @Autowired
    private MateRecordService mateRecordService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/materecord";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:materecord:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = mateRecordService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{mateRecordId}")
    @ResponseBody
  //  @RequiresPermissions("sys:materecord:info")
    public Resultful info(@PathVariable("mateRecordId") Long mateRecordId){
        MateRecordEntity mateRecord = mateRecordService.getById(mateRecordId);

        return Resultful.ok().put("mateRecord", mateRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:materecord:save")
    public Resultful save(@RequestBody MateRecordEntity mateRecord){
        mateRecordService.save(mateRecord);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:materecord:update")
    public Resultful update(@RequestBody MateRecordEntity mateRecord){
        ValidatorUtils.validateEntity(mateRecord);
        mateRecordService.updateById(mateRecord);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:materecord:delete")
    public Resultful delete(@RequestBody Long[] mateRecordIds){
        mateRecordService.removeByIds(Arrays.asList(mateRecordIds));

        return Resultful.ok();
    }

}
