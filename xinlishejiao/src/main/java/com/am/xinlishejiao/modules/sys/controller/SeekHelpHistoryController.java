package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.SeekHelpHistoryEntity;
import com.am.xinlishejiao.modules.sys.service.SeekHelpHistoryService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 求助历史记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:51
 */
@Controller
@RequestMapping("/sys/seekhelphistory")
public class SeekHelpHistoryController {
    @Autowired
    private SeekHelpHistoryService seekHelpHistoryService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/seekhelphistory";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:seekhelphistory:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = seekHelpHistoryService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
  //  @RequiresPermissions("sys:seekhelphistory:info")
    public Resultful info(@PathVariable("id") Long id){
        SeekHelpHistoryEntity seekHelpHistory = seekHelpHistoryService.getById(id);

        return Resultful.ok().put("seekHelpHistory", seekHelpHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:seekhelphistory:save")
    public Resultful save(@RequestBody SeekHelpHistoryEntity seekHelpHistory){
        seekHelpHistoryService.save(seekHelpHistory);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:seekhelphistory:update")
    public Resultful update(@RequestBody SeekHelpHistoryEntity seekHelpHistory){
        ValidatorUtils.validateEntity(seekHelpHistory);
        seekHelpHistoryService.updateById(seekHelpHistory);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:seekhelphistory:delete")
    public Resultful delete(@RequestBody Long[] ids){
        seekHelpHistoryService.removeByIds(Arrays.asList(ids));

        return Resultful.ok();
    }

}
