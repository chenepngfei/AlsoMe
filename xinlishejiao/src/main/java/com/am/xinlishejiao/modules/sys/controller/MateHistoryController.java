package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.MateHistoryEntity;
import com.am.xinlishejiao.modules.sys.service.MateHistoryService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 匹配历史表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:53
 */
@Controller
@RequestMapping("/sys/matehistory")
public class MateHistoryController {
    @Autowired
    private MateHistoryService mateHistoryService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/matehistory";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:matehistory:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = mateHistoryService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{mateHistoryId}")
    @ResponseBody
  //  @RequiresPermissions("sys:matehistory:info")
    public Resultful info(@PathVariable("mateHistoryId") Long mateHistoryId){
        MateHistoryEntity mateHistory = mateHistoryService.getById(mateHistoryId);

        return Resultful.ok().put("mateHistory", mateHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:matehistory:save")
    public Resultful save(@RequestBody MateHistoryEntity mateHistory){
        mateHistoryService.save(mateHistory);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:matehistory:update")
    public Resultful update(@RequestBody MateHistoryEntity mateHistory){
        ValidatorUtils.validateEntity(mateHistory);
        mateHistoryService.updateById(mateHistory);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:matehistory:delete")
    public Resultful delete(@RequestBody Long[] mateHistoryIds){
        mateHistoryService.removeByIds(Arrays.asList(mateHistoryIds));

        return Resultful.ok();
    }

}
