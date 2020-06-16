package com.alsome.alsome_create_model.modules.sys.controller;

import java.util.Arrays;
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
import com.alsome.alsome_create_model.modules.sys.entity.PsychologicalStatusQuestionnaire;
import com.alsome.alsome_create_model.modules.sys.service.PsychologicalStatusQuestionnaireService;


/**
 * 中国大学生心理状态调查问卷
 *
 * @author cpf
 * @email chenpfmail@163.com
 * @date 2020-06-13 11:28:54
 */
@RestController
@RequestMapping("sys/plq")
public class PsychologicalStatusQuestionnaireController {
    @Autowired
    private PsychologicalStatusQuestionnaireService psychologicalStatusQuestionnaireService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = psychologicalStatusQuestionnaireService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    @RequestMapping("save")
    public Resultful createReport(@RequestBody String jsonStr){
        Long report = psychologicalStatusQuestionnaireService.createReport(jsonStr);
        return Resultful.ok().put("id",report);
    }




    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Resultful info(@PathVariable("id") Long id){
        PsychologicalStatusQuestionnaire psychologicalStatusQuestionnaire = psychologicalStatusQuestionnaireService.getById(id);

        return Resultful.ok().put("psychologicalStatusQuestionnaire", psychologicalStatusQuestionnaire);
    }

    /**
     * 保存
     */
//    @RequestMapping("/save")
//    public Resultful save(@RequestBody PsychologicalStatusQuestionnaire psychologicalStatusQuestionnaire){
//        psychologicalStatusQuestionnaireService.save(psychologicalStatusQuestionnaire);
//
//        return Resultful.ok();
//    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Resultful update(@RequestBody PsychologicalStatusQuestionnaire psychologicalStatusQuestionnaire){
        ValidatorUtils.validateEntity(psychologicalStatusQuestionnaire);
        psychologicalStatusQuestionnaireService.updateById(psychologicalStatusQuestionnaire);
        
        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Resultful delete(@RequestBody Long[] ids){
        psychologicalStatusQuestionnaireService.removeByIds(Arrays.asList(ids));

        return Resultful.ok();
    }

}
