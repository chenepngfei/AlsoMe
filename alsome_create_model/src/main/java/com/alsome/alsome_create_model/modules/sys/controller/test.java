package com.alsome.alsome_create_model.modules.sys.controller;

import com.AlsoMe.commons.enums.AnxietyPerformanceEnums;
import com.AlsoMe.commons.enums.DepressionPerformanceEnums;
import com.AlsoMe.commons.utils.DateUtils;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;
import com.alsome.alsome_create_model.modules.sys.entity.PsychologicalSurvey;
import com.alsome.alsome_create_model.modules.sys.entity.PsychologicalUestionnaireReport;
import com.alsome.alsome_create_model.modules.sys.entity.ReportingSource;
import com.alsome.alsome_create_model.modules.sys.entity.ReportingUnit;
import com.alsome.alsome_create_model.modules.sys.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 心理状况调查
 *
 * @author cpf
 * @email chenpfmail@163.com
 * @date 2020-06-08 15:24:09
 */
@RestController
//@CrossOrigin(origins = "http://112.126.97.88:8080")
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/")
@Slf4j
public class test {
    @Autowired
    private PsychologicalSurveyService psychologicalSurveyService;
    @Autowired
    private ReportingSourceService reportingSourceService;
    @Autowired
    private ReportingUnitService reportingUnitService;
    @Autowired
    private PsychologicalStatusQuestionnaireService psychologicalStatusQuestionnaireService;
    @Autowired
    private PsychologicalUestionnaireReportService psychologicalUestionnaireReportService;


    /**
     * 列表
     */
    @RequestMapping("/list")
    public Resultful list(@RequestParam Map<String, Object> params){
        PageUtils page = psychologicalSurveyService.queryPage(params);

        return Resultful.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info")
    public Resultful info(@RequestBody PsychologicalUestionnaireReport psychologicalUestionnaireReport ){


        Map<String,Object> map = new HashMap<>();
        //PsychologicalSurvey psychologicalSurvey = psychologicalSurveyService.getById(id);
        PsychologicalUestionnaireReport psychologicalSurvey = psychologicalUestionnaireReportService.getPsychologicalUestionnaireReport(psychologicalUestionnaireReport);
        if(psychologicalSurvey != null){
//             ReportingSource byId = reportingSourceService.getById(psychologicalSurvey.getReportingSourceId());
//             ReportingUnit byId1 = reportingUnitService.getById(psychologicalSurvey.getReportingUnitId());
            map.put("reportingSource","2020夏•中国大学生心理状况调研问卷");
            map.put("reportingUnit","北京心西游季教育科技有限公司");

            //焦虑情况积分
            map.put("anxietyScores",psychologicalSurvey.getAnxietyScores());
            //焦虑情况表现
            map.put("anxietyPerformance", AnxietyPerformanceEnums.getDescribeByKey(psychologicalSurvey.getAnxietyScores()));
            //抑郁自评得分
            map.put("depressionScores",psychologicalSurvey.getDepressionScores());
            //抑郁状况表现
            map.put("depressionPerformance", DepressionPerformanceEnums.getDescribeByKey(psychologicalSurvey.getDepressionScores()));
            //压力积分
            map.put("psychologicalScores",psychologicalSurvey.getPsychologicalScores());
            //压力来源
            map.put("psychologicalSource",psychologicalSurvey.getPsychologicalSource());
            //创建日期
            map.put("reportingDate", DateUtils.format_zn(psychologicalSurvey.getCrTime()));
            //问卷编号
            map.put("questionnaireNumber","202006-HA");
            //学习生活满意度
            map.put("lifeSatisfaction","你对目前学习生活满意程度不高，表现在你对现在的学校喜欢程度感到比 较喜欢，对现在所学习的专业喜欢程度感到非常喜欢。可尝试参与校园中的各 类活动，与他人建立良好关系能在一定程度上提升学习生活的幸福感。");
            map.put("generalAdvice","总体而言，你的心理状况呈现出无焦虑和无抑郁症状，你表现出较大的学业 压力，需要你继续保持积极心态，并随时关注和调节。");
            //温馨提示
            map.put("warmPrompt","温馨提示:当你感觉压力大的时候，运动健身是很好的选择，这样能有效减 少压力，放松心情。而且与植物亲近也是很好的减压方式，身边放一个绿植，或 者常常到大自然间散步，天然氧吧将给你带来愉悦的好心情。");

        }

        return Resultful.ok().put("param", map);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}/{email}")
    public Resultful info(@PathVariable("id") Long id,@PathVariable("email") String email){
        Map<String,Object> map = new HashMap<>();
        //PsychologicalSurvey psychologicalSurvey = psychologicalSurveyService.getById(id);
        PsychologicalUestionnaireReport psychologicalSurvey = psychologicalUestionnaireReportService.getById(id);
        if(psychologicalSurvey != null){
            // ReportingSource byId = reportingSourceService.getById(psychologicalSurvey.getReportingSourceId());
            // ReportingUnit byId1 = reportingUnitService.getById(psychologicalSurvey.getReportingUnitId());
            map.put("reportingSource","2020夏•中国大学生心理状况调研问卷");
            map.put("reportingUnit","北京心西游季教育科技有限公司");

            //焦虑情况积分
            map.put("anxietyScores",psychologicalSurvey.getAnxietyScores());
            //焦虑情况表现
            map.put("anxietyPerformance", AnxietyPerformanceEnums.getDescribeByKey(psychologicalSurvey.getAnxietyScores()));
            //抑郁自评得分
            map.put("depressionScores",psychologicalSurvey.getDepressionScores());
            //抑郁状况表现
            map.put("depressionPerformance", DepressionPerformanceEnums.getDescribeByKey(psychologicalSurvey.getDepressionScores()));
            //压力积分
            map.put("psychologicalScores",psychologicalSurvey.getPsychologicalScores());
            //压力来源
            map.put("psychologicalSource",psychologicalSurvey.getPsychologicalSource());
            //创建日期
            map.put("reportingDate", DateUtils.format_zn(psychologicalSurvey.getCrTime()));
            //问卷编号
            map.put("questionnaireNumber","202006-HA");
            //学习生活满意度
            map.put("lifeSatisfaction","你对目前学习生活满意程度不高，表现在你对现在的学校喜欢程度感到比 较喜欢，对现在所学习的专业喜欢程度感到非常喜欢。可尝试参与校园中的各 类活动，与他人建立良好关系能在一定程度上提升学习生活的幸福感。");
            map.put("generalAdvice","总体而言，你的心理状况呈现出无焦虑和无抑郁症状，你表现出较大的学业 压力，需要你继续保持积极心态，并随时关注和调节。");
            //温馨提示
            map.put("warmPrompt","温馨提示:当你感觉压力大的时候，运动健身是很好的选择，这样能有效减 少压力，放松心情。而且与植物亲近也是很好的减压方式，身边放一个绿植，或 者常常到大自然间散步，天然氧吧将给你带来愉悦的好心情。");

        }

        return Resultful.ok().put("param", map);
    }

    /**
     * 信息
     */
    @RequestMapping("/info2/{id}")
    public Resultful info2(@PathVariable("id") Long id){
        Map<String,Object> map = new HashMap<>();
        PsychologicalSurvey psychologicalSurvey = psychologicalSurveyService.getById(id);
        if(psychologicalSurvey != null){
            ReportingSource byId = reportingSourceService.getById(psychologicalSurvey.getReportingSourceId());
            ReportingUnit byId1 = reportingUnitService.getById(psychologicalSurvey.getReportingUnitId());
            map.put("reportingSource",byId.getName());
            map.put("reportingUnit",byId1.getName());


            map.put("anxietyScores",psychologicalSurvey.getAnxietyScores());
            map.put("anxietyPerformance",psychologicalSurvey.getAnxietyPerformance());
            map.put("depressionScores",psychologicalSurvey.getDepressionScores());
            map.put("depressionPerformance",psychologicalSurvey.getDepressionPerformance());
            map.put("psychologicalScores",psychologicalSurvey.getPsychologicalScores());
            map.put("psychologicalSource",psychologicalSurvey.getPsychologicalSource());
            map.put("reportingDate", DateUtils.format_zn(psychologicalSurvey.getCrtime()));
            map.put("questionnaireNumber",psychologicalSurvey.getQuestionnaireNumber());

            map.put("lifeSatisfaction",psychologicalSurvey.getLifeSatisfaction());
            map.put("generalAdvice",psychologicalSurvey.getGeneralAdvice());
            map.put("warmPrompt",psychologicalSurvey.getWarmPrompt());

        }

        Map<String,Object> mapparam = new HashMap<>();
        mapparam.put("reportingSource","报告来源");
        mapparam.put("reportingUnit","报告单位");
        mapparam.put("questionnaireNumber","问卷编号");
        mapparam.put("anxietyScores","焦虑情况表现");
        mapparam.put("anxietyPerformance","焦虑情况表现");
        mapparam.put("depressionScores","抑郁自评得分");
        mapparam.put("depressionPerformance","抑郁状况表现");
        mapparam.put("psychologicalScores","压力感受得分");
        mapparam.put("psychologicalSource","压力来源");
        mapparam.put("reportingDate", "报告时间");

        mapparam.put("lifeSatisfaction", "学习生活满意度");
        mapparam.put("generalAdvice", "总体状况及专家建议");
        mapparam.put("warmPrompt", "温馨提示");
        map.put("zhushi",mapparam);
        return Resultful.ok().put("param", map);
    }


    @RequestMapping(value = "create/report",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Resultful createReport(@RequestBody String jsonStr){
        log.info("jsonStr:{}",jsonStr);
        log.info("-------------------------------");
        try {
            Long report = psychologicalStatusQuestionnaireService.createReport(jsonStr);
            if(report == 0){
                return Resultful.error(0,"操作失败");
            }
            return Resultful.ok().put("id",report);
        }catch (Exception e){
            e.printStackTrace();
            return Resultful.error(1,"操作失败");
        }
    }


    @RequestMapping(value = "tt2")
    public Resultful qweqw( String jsonStr){
         jsonStr = "{\"jsonStr\":[{\"id\":1}";
        log.info("jsonStr:{}",jsonStr);
        log.info("-------------------------------");
        try {
            Long report = psychologicalStatusQuestionnaireService.createReport(jsonStr);
            if(report == 0){
                return Resultful.error(0,"操作失败");
            }
            return Resultful.ok().put("id",report);
        }catch (Exception e){
            e.printStackTrace();
            return Resultful.error(1,"操作失败");
        }

    }


    @RequestMapping("test")
    public Resultful test(){
        String h = "[{\"id\":1,\"choose\":[]},{\"id\":2,\"choose\":[]}]";
//        String jsonStr = "[{id: 1,choose: [1],},{id: 2,choose: [3],}" +
//                ",{id: 3,choose: [3],},{id: 4,choose: [2,3],}" +
//                ",{id: 5,choose: [1],},{id: 6,choose: [3],}" +
//                ",{id: 7,choose: [3],},{id: 8,choose: [3],}" +
//                ",{id: 9,choose: [3,5,6],},{id: 10,choose: [1,2,3],}" +
//                ",{id: 11,choose: [2],},{id: 12,choose: [3],}" +
//                ",{id: 13,choose: [3],},{id: 14,choose: [3],}" +
//                ",{id: 15,choose: [3],},{id: 16,choose: [3],}" +
//                ",{id: 17,choose: [3],},{id: 18,choose: [3],}" +
//                ",{id: 19,choose: [3],},{id: 20,choose: [3],}" +
//                ",{id: 21,choose: [3],},{id: 22,choose: [3],}" +
//                ",{id: 23,choose: [3],},{id: 24,choose: [3],}" +
//                ",{id: 25,choose: [3],},{id: 26,choose: [3],}" +
//                ",{id: 27,choose: [3],},{id: 28,choose: [3],}" +
//                ",{id: 29,choose: [3,4,6],},{id: 30,choose: [3,5,6],}" +
//                ",{id: 31,choose: [\"chenpfmail@163.com\"],}]";

//        String jsonStr = "[{\"id\":1,\"choose\":\"[]\"},{\"id\":2,\"choose\":\"[]\"},{\"id\":3,\"choose\":\"[]\"},{\"id\":4,\"choose\":\"[]\"},{\"id\":5,\"choose\":\"[]\"},{\"id\":6,\"choose\":\"[]\"},{\"id\":7,\"choose\":\"[]\"},{\"id\":8,\"choose\":\"[]\"},{\"id\":9,\"choose\":\"[]\"},{\"id\":10,\"choose\":\"[]\"},{\"id\":11,\"choose\":\"[]\"},{\"id\":12,\"choose\":\"[]\"},{\"id\":13,\"choose\":\"[]\"},{\"id\":14,\"choose\":\"[]\"},{\"id\":15,\"choose\":\"[]\"},{\"id\":16,\"choose\":\"[]\"},{\"id\":17,\"choose\":\"[]\"},{\"id\":18,\"choose\":\"[]\"},{\"id\":19,\"choose\":\"[]\"},{\"id\":20,\"choose\":\"[]\"},{\"id\":21,\"choose\":\"[]\"},{\"id\":22,\"choose\":\"[]\"},{\"id\":23,\"choose\":\"[]\"},{\"id\":24,\"choose\":\"[]\"},{\"id\":25,\"choose\":\"[]\"},{\"id\":26,\"choose\":\"[]\"},{\"id\":27,\"choose\":\"[]\"},{\"id\":28,\"choose\":\"[]\"},{\"id\":29,\"choose\":\"[]\"},{\"id\":30,\"choose\":\"[1]\"}]";
//String jsonStr = "[{\"id\":1,\"choose\":\"[]\"},{\"id\":2,\"choose\":\"[]\"},{\"id\":3,\"choose\":\"[]\"},{\"id\":4,\"choose\":\"[]\"},{\"id\":5,\"choose\":\"[]\"},{\"id\":6,\"choose\":\"[]\"},{\"id\":7,\"choose\":\"[]\"},{\"id\":8,\"choose\":\"[]\"},{\"id\":9,\"choose\":\"[]\"},{\"id\":10,\"choose\":\"[]\"},{\"id\":11,\"choose\":\"[]\"},{\"id\":12,\"choose\":\"[]\"},{\"id\":13,\"choose\":\"[]\"},{\"id\":14,\"choose\":\"[]\"},{\"id\":15,\"choose\":\"[]\"},{\"id\":16,\"choose\":\"[]\"},{\"id\":17,\"choose\":\"[]\"},{\"id\":18,\"choose\":\"[]\"},{\"id\":19,\"choose\":\"[]\"},{\"id\":20,\"choose\":\"[]\"},{\"id\":21,\"choose\":\"[]\"},{\"id\":22,\"choose\":\"[]\"},{\"id\":23,\"choose\":\"[]\"},{\"id\":24,\"choose\":\"[]\"},{\"id\":25,\"choose\":\"[]\"},{\"id\":26,\"choose\":\"[]\"},{\"id\":27,\"choose\":\"[1]\"},{\"id\":28,\"choose\":\"[]\"},{\"id\":29,\"choose\":\"[5]\"},{\"id\":30,\"choose\":\"[]\"},{\"id\":31,\"choose\":\"[]\"}]";
    String jsonStr = "{\"jsonStr\":[{\"id\":1,\"choose\":[2]},{\"id\":2,\"choose\":[2]},{\"id\":3,\"choose\":[2]},{\"id\":4,\"choose\":[13]},{\"id\":5,\"choose\":[2]},{\"id\":6,\"choose\":[2]},{\"id\":7,\"choose\":[2]},{\"id\":8,\"choose\":[5]},{\"id\":9,\"choose\":[2]},{\"id\":10,\"choose\":[2]},{\"id\":11,\"choose\":[2]},{\"id\":12,\"choose\":[2]},{\"id\":13,\"choose\":[2]},{\"id\":14,\"choose\":[2]},{\"id\":15,\"choose\":[2]},{\"id\":16,\"choose\":[2]},{\"id\":17,\"choose\":[2]},{\"id\":18,\"choose\":[2]},{\"id\":19,\"choose\":[2]},{\"id\":20,\"choose\":[2]},{\"id\":21,\"choose\":[2]},{\"id\":22,\"choose\":[2]},{\"id\":23,\"choose\":[2]},{\"id\":24,\"choose\":[2]},{\"id\":25,\"choose\":[2]},{\"id\":26,\"choose\":[2]},{\"id\":27,\"choose\":[2]},{\"id\":28,\"choose\":[2]},{\"id\":29,\"choose\":[8]},{\"id\":30,\"choose\":[2]},{\"id\":31,\"choose\":[\"6430@qq.com\"]}]}";
    Long report = psychologicalStatusQuestionnaireService.createReport(jsonStr);
        return Resultful.ok().put("id",report);
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
    public Resultful update(@RequestBody PsychologicalSurvey psychologicalSurvey){
        //ValidatorUtils.validateEntity(psychologicalSurvey);

        psychologicalSurveyService.updateById(psychologicalSurvey);

        return Resultful.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Resultful delete(@RequestBody Long[] ids){
        psychologicalSurveyService.removeByIds(Arrays.asList(ids));

        return Resultful.ok();
    }

}
