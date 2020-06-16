package com.alsome.alsome_create_model.modules.sys.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;
import com.AlsoMe.commons.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alsome.alsome_create_model.modules.sys.entity.PsychologicalUestionnaireReport;
import com.alsome.alsome_create_model.modules.sys.service.PsychologicalUestionnaireReportService;
import redis.clients.jedis.params.Params;


/**
 * 心理调研问卷结果报告表
 *
 * @author cpf
 * @email chenpfmail@163.com
 * @date 2020-06-13 11:28:54
 */
@RestController
@RequestMapping("sys/psreport")
public class PsychologicalUestionnaireReportController {
    @Autowired
    private PsychologicalUestionnaireReportService psychologicalUestionnaireReportService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = psychologicalUestionnaireReportService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Resultful info(@PathVariable("id") Long id){
        PsychologicalUestionnaireReport psychologicalUestionnaireReport = psychologicalUestionnaireReportService.getById(id);


        return Resultful.ok().put("psychologicalUestionnaireReport", psychologicalUestionnaireReport);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Resultful save(@RequestBody PsychologicalUestionnaireReport psychologicalUestionnaireReport){
        psychologicalUestionnaireReportService.save(psychologicalUestionnaireReport);

        return Resultful.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Resultful update(@RequestBody PsychologicalUestionnaireReport psychologicalUestionnaireReport){
        ValidatorUtils.validateEntity(psychologicalUestionnaireReport);
        psychologicalUestionnaireReportService.updateById(psychologicalUestionnaireReport);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Resultful delete(@RequestBody Long[] ids){
        psychologicalUestionnaireReportService.removeByIds(Arrays.asList(ids));

        return Resultful.ok();
    }

}
