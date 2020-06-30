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
import com.am.xinlishejiao.modules.sys.entity.QuizzesCardTypeEntity;
import com.am.xinlishejiao.modules.sys.service.QuizzesCardTypeService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 卡片类别表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:52
 */
@Controller
@RequestMapping("/sys/quizzescardtype")
public class QuizzesCardTypeController {
    @Autowired
    private QuizzesCardTypeService quizzesCardTypeService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/quizzescardtype";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:quizzescardtype:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = quizzesCardTypeService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{quizzesTypeId}")
    @ResponseBody
  //  @RequiresPermissions("sys:quizzescardtype:info")
    public Resultful info(@PathVariable("quizzesTypeId") Long quizzesTypeId){
        QuizzesCardTypeEntity quizzesCardType = quizzesCardTypeService.getById(quizzesTypeId);

        return Resultful.ok().put("quizzesCardType", quizzesCardType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:quizzescardtype:save")
    public Resultful save(@RequestBody QuizzesCardTypeEntity quizzesCardType){
        quizzesCardTypeService.save(quizzesCardType);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:quizzescardtype:update")
    public Resultful update(@RequestBody QuizzesCardTypeEntity quizzesCardType){
        ValidatorUtils.validateEntity(quizzesCardType);
        quizzesCardTypeService.updateById(quizzesCardType);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:quizzescardtype:delete")
    public Resultful delete(@RequestBody Long[] quizzesTypeIds){
        quizzesCardTypeService.removeByIds(Arrays.asList(quizzesTypeIds));

        return Resultful.ok();
    }

}
