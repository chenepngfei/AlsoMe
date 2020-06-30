package com.am.xinlishejiao.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.AlsoMe.commons.validator.ValidatorUtils;
import com.am.xinlishejiao.modules.sys.entity.ExaminationPaperEntity;
import com.am.xinlishejiao.modules.sys.service.ExaminationPaperService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 考题管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:54
 */
@Controller
@RequestMapping("/sys/examinationpaper")
public class ExaminationPaperController {
    @Autowired
    private ExaminationPaperService examinationPaperService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/examinationpaper";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:examinationpaper:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = examinationPaperService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{examinationPaperId}")
    @ResponseBody
  //  @RequiresPermissions("sys:examinationpaper:info")
    public Resultful info(@PathVariable("examinationPaperId") Long examinationPaperId){
        ExaminationPaperEntity examinationPaper = examinationPaperService.getById(examinationPaperId);

        return Resultful.ok().put("examinationPaper", examinationPaper);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:examinationpaper:save")
    public Resultful save(@RequestBody ExaminationPaperEntity examinationPaper){
        examinationPaperService.save(examinationPaper);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:examinationpaper:update")
    public Resultful update(@RequestBody ExaminationPaperEntity examinationPaper){
        ValidatorUtils.validateEntity(examinationPaper);
        examinationPaperService.updateById(examinationPaper);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:examinationpaper:delete")
    public Resultful delete(@RequestBody Long[] examinationPaperIds){
        examinationPaperService.removeByIds(Arrays.asList(examinationPaperIds));

        return Resultful.ok();
    }

}
