package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.QuizzesResultEntity;
import com.am.xinlishejiao.modules.sys.service.QuizzesResultService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 用户测试结果表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:51
 */
@Controller
@RequestMapping("/sys/quizzesresult")
public class QuizzesResultController {
    @Autowired
    private QuizzesResultService quizzesResultService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/quizzesresult";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:quizzesresult:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = quizzesResultService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{quizzesResultId}")
    @ResponseBody
  //  @RequiresPermissions("sys:quizzesresult:info")
    public Resultful info(@PathVariable("quizzesResultId") Long quizzesResultId){
        QuizzesResultEntity quizzesResult = quizzesResultService.getById(quizzesResultId);

        return Resultful.ok().put("quizzesResult", quizzesResult);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:quizzesresult:save")
    public Resultful save(@RequestBody QuizzesResultEntity quizzesResult){
        quizzesResultService.save(quizzesResult);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:quizzesresult:update")
    public Resultful update(@RequestBody QuizzesResultEntity quizzesResult){
        ValidatorUtils.validateEntity(quizzesResult);
        quizzesResultService.updateById(quizzesResult);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:quizzesresult:delete")
    public Resultful delete(@RequestBody Long[] quizzesResultIds){
        quizzesResultService.removeByIds(Arrays.asList(quizzesResultIds));

        return Resultful.ok();
    }

}
