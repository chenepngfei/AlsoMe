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
import com.am.xinlishejiao.modules.sys.entity.CopywritingManageEntity;
import com.am.xinlishejiao.modules.sys.service.CopywritingManageService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 文本管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:54
 */
@Controller
@RequestMapping("/sys/copywritingmanage")
public class CopywritingManageController {
    @Autowired
    private CopywritingManageService copywritingManageService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/copywritingmanage";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:copywritingmanage:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = copywritingManageService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{copywritingId}")
    @ResponseBody
  //  @RequiresPermissions("sys:copywritingmanage:info")
    public Resultful info(@PathVariable("copywritingId") Long copywritingId){
        CopywritingManageEntity copywritingManage = copywritingManageService.getById(copywritingId);

        return Resultful.ok().put("copywritingManage", copywritingManage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:copywritingmanage:save")
    public Resultful save(@RequestBody CopywritingManageEntity copywritingManage){
        copywritingManageService.save(copywritingManage);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:copywritingmanage:update")
    public Resultful update(@RequestBody CopywritingManageEntity copywritingManage){
        ValidatorUtils.validateEntity(copywritingManage);
        copywritingManageService.updateById(copywritingManage);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:copywritingmanage:delete")
    public Resultful delete(@RequestBody Long[] copywritingIds){
        copywritingManageService.removeByIds(Arrays.asList(copywritingIds));

        return Resultful.ok();
    }

}
