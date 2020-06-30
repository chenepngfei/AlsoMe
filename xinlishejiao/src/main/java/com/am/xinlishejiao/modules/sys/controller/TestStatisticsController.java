package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.TestStatisticsEntity;
import com.am.xinlishejiao.modules.sys.service.TestStatisticsService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 测试题统计管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:50
 */
@Controller
@RequestMapping("/sys/teststatistics")
public class TestStatisticsController {
    @Autowired
    private TestStatisticsService testStatisticsService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/teststatistics";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:teststatistics:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = testStatisticsService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{testStatisticsId}")
    @ResponseBody
  //  @RequiresPermissions("sys:teststatistics:info")
    public Resultful info(@PathVariable("testStatisticsId") Long testStatisticsId){
        TestStatisticsEntity testStatistics = testStatisticsService.getById(testStatisticsId);

        return Resultful.ok().put("testStatistics", testStatistics);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:teststatistics:save")
    public Resultful save(@RequestBody TestStatisticsEntity testStatistics){
        testStatisticsService.save(testStatistics);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:teststatistics:update")
    public Resultful update(@RequestBody TestStatisticsEntity testStatistics){
        ValidatorUtils.validateEntity(testStatistics);
        testStatisticsService.updateById(testStatistics);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:teststatistics:delete")
    public Resultful delete(@RequestBody Long[] testStatisticsIds){
        testStatisticsService.removeByIds(Arrays.asList(testStatisticsIds));

        return Resultful.ok();
    }

}
