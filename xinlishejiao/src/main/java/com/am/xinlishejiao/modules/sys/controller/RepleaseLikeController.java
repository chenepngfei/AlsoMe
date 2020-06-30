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
import com.am.xinlishejiao.modules.sys.entity.RepleaseLikeEntity;
import com.am.xinlishejiao.modules.sys.service.RepleaseLikeService;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;



/**
 * 站内点赞,收藏表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 11:16:52
 */
@Controller
@RequestMapping("/sys/repleaselike")
public class RepleaseLikeController {
    @Autowired
    private RepleaseLikeService repleaseLikeService;


    /**
     * 列表
     */
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> params){

        return "modules/sys/repleaselike";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
   // @RequiresPermissions("sys:repleaselike:list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = repleaseLikeService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{likeid}")
    @ResponseBody
  //  @RequiresPermissions("sys:repleaselike:info")
    public Resultful info(@PathVariable("likeid") Long likeid){
        RepleaseLikeEntity repleaseLike = repleaseLikeService.getById(likeid);

        return Resultful.ok().put("repleaseLike", repleaseLike);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
   // @RequiresPermissions("sys:repleaselike:save")
    public Resultful save(@RequestBody RepleaseLikeEntity repleaseLike){
        repleaseLikeService.save(repleaseLike);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
   // @RequiresPermissions("sys:repleaselike:update")
    public Resultful update(@RequestBody RepleaseLikeEntity repleaseLike){
        ValidatorUtils.validateEntity(repleaseLike);
        repleaseLikeService.updateById(repleaseLike);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    //@RequiresPermissions("sys:repleaselike:delete")
    public Resultful delete(@RequestBody Long[] likeids){
        repleaseLikeService.removeByIds(Arrays.asList(likeids));

        return Resultful.ok();
    }

}
