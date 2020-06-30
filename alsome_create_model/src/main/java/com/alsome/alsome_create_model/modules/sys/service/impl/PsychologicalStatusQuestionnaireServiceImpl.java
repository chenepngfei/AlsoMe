package com.alsome.alsome_create_model.modules.sys.service.impl;

import com.AlsoMe.commons.enums.*;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;
import com.alsome.alsome_create_model.common.utils.SendEmailUtils;
import com.alsome.alsome_create_model.modules.sys.dao.PsychologicalStatusQuestionnaireDao;
import com.alsome.alsome_create_model.modules.sys.entity.PsychologicalStatusQuestionnaire;
import com.alsome.alsome_create_model.modules.sys.entity.PsychologicalUestionnaireReport;
import com.alsome.alsome_create_model.modules.sys.service.PsychologicalStatusQuestionnaireService;
import com.alsome.alsome_create_model.modules.sys.service.PsychologicalUestionnaireReportService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;


@Service("psychologicalStatusQuestionnaireService")
@Slf4j
public class PsychologicalStatusQuestionnaireServiceImpl extends ServiceImpl<PsychologicalStatusQuestionnaireDao, PsychologicalStatusQuestionnaire> implements PsychologicalStatusQuestionnaireService {
    @Value("${spring.mail.username}")
    private String from;
    @Value("${templatePath}")
    private String templatePath;
    @Autowired
    private SendEmailUtils sendEmailUtils;
    @Autowired
    PsychologicalUestionnaireReportService psychologicalUestionnaireReportService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PsychologicalStatusQuestionnaire> page = this.page(
                new Query<PsychologicalStatusQuestionnaire>().getPage(params),
                new QueryWrapper<PsychologicalStatusQuestionnaire>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public Long createReport(String jsonstr) {
        //问卷报告
        PsychologicalUestionnaireReport psychologicalUestionnaireReport = new PsychologicalUestionnaireReport();
        //调查问卷
        PsychologicalStatusQuestionnaire psychologicalStatusQuestionnaire = new PsychologicalStatusQuestionnaire();

        Integer anxietyScores = 0;//焦虑得分
        Integer depressionScores = 0; //抑郁自评得分
        Integer psychologicalScores = 0; //压力感受得分
        String covidLifeSocre = "";//疫情对生活的影响
        String covidLifeSocreText = "";//疫情对生活的影响
        Date nowDate = new Date();

        if(StringUtils.isNotBlank(jsonstr)){
            JSONObject jsonObject = JSONObject.fromObject(jsonstr);
            if(jsonObject.isEmpty()){
                return 0l;
            }
            jsonstr = jsonObject.get("jsonStr").toString();
        }


        try {
            JSONArray jsonArray = JSONArray.fromObject(jsonstr);
            log.info("解析数据：{}", jsonArray);

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = JSONObject.fromObject(jsonArray.get(i).toString());
                if (!jsonObject.isEmpty()) {
                    Object get_id = jsonObject.get("id");
                    log.info("get_id:{}", get_id);
                    if (get_id == null) {
                        continue;
                    }
                    JSONArray choose = jsonObject.getJSONArray("choose");
                    if (choose.isEmpty()) {
                        continue;
                    }

                    Integer key_id = 0;
                    if (!get_id.equals(31)) {
                        key_id = (int) choose.get(0);

                        if (key_id <= 0) {
                            continue;
                        }

                    }


                    if (get_id.equals(1)) { //设置年龄
                        psychologicalStatusQuestionnaire.setAge(key_id);
                    }
                    if (get_id.equals(2)) { //现在在读
                        psychologicalStatusQuestionnaire.setReading(key_id);
                    }
                    if (get_id.equals(3)) {  //攻读的学位
                        psychologicalStatusQuestionnaire.setDegree(key_id);
                    }
                    if (get_id.equals(4)) { //专业

                        psychologicalStatusQuestionnaire.setProfessionals(getJsonArrayToString(choose));
                    }
                    if (get_id.equals(5)) { //地理位置
                        psychologicalStatusQuestionnaire.setAddress(key_id);
                    }
                    if (get_id.equals(6)) { //喜欢现在的学校吗
                        psychologicalUestionnaireReport.setLikeSchool(key_id);
                        psychologicalStatusQuestionnaire.setLikeSchool(key_id);
                    }
                    if (get_id.equals(7)) { //喜欢你现在的专业
                        psychologicalUestionnaireReport.setLikeProfessional(key_id);
                        psychologicalStatusQuestionnaire.setLikeProfessional(key_id);
                    }
                    if (get_id.equals(8)) { //学习压力多大
                        psychologicalUestionnaireReport.setPsychologicalScores(AcademicPressureEnums.getNameByKey(key_id));
                        psychologicalStatusQuestionnaire.setAcademicPressure(key_id);
                    }
                    if (get_id.equals(9)) { //压力来源 getJsonArrayToString
                        String psychologicalSource = getJsonArrayToString(choose);
                        psychologicalUestionnaireReport.setPsychologicalSource(EmotionalImpactEnums.getNameByKeys(psychologicalSource));
                        psychologicalStatusQuestionnaire.setPressureSource(psychologicalSource);
                    }
                    if (get_id.equals(10)) { //情绪受那些方面影响
                        String emotionalImpact = getJsonArrayToString(choose);
                        psychologicalUestionnaireReport.setEmotionalImpact(EmotionalImpactEnums.getNameByKeys(emotionalImpact));
                        psychologicalStatusQuestionnaire.setEmotionalImpact(emotionalImpact);
                    }
                    if (get_id.equals(11)) { //觉得自己比以前更容易紧张或起急
                        anxietyScores += ChanceEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setNervousAnxious(key_id);
                    }
                    if (get_id.equals(12)) { //会无缘无故感到害怕
                        anxietyScores += ChanceEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setBeAfraid(key_id);
                    }
                    if (get_id.equals(13)) { //你容易心烦意乱或心跳加快:
                        anxietyScores += ChanceEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setUpsetHeartbeat(key_id);
                    }
                    if (get_id.equals(14)) { //觉得一切都好，也不会发生什么不幸:
                        anxietyScores += ChanceFanEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setNotMisfortune(key_id);
                    }
                    if (get_id.equals(15)) { //因为头痛(头晕)、颈痛和背痛而苦恼:
                        anxietyScores += ChanceEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setHeadachePain(key_id);
                    }
                    if (get_id.equals(16)) { //因为胃疼和消化不良而苦恼
                        anxietyScores += ChanceEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setStomachUpset(key_id);
                    }
                    if (get_id.equals(17)) { //很容易入睡并且一夜睡得很好:
                        depressionScores += ChanceFanEnums.getValueByKey(key_id);
                        anxietyScores += ChanceFanEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setSleepWell(key_id);
                    }
                    if (get_id.equals(18)) { //坐卧不安，难以保持平静:
                        anxietyScores += ChanceEnums.getValueByKey(key_id);
                        depressionScores += ChanceEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setNotCalm(key_id);
                    }
                    if (get_id.equals(19)) { //感到情绪低落，沮丧、郁闷:
                        depressionScores += ChanceEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setBadMood(key_id);
                    }
                    if (get_id.equals(20)) { //你要哭或想哭
                        depressionScores += ChanceEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setWantCry(key_id);
                    }
                    if (get_id.equals(21)) { //你与他人接触时感到愉快:
                        depressionScores += ChanceFanEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setFeelHappy(key_id);
                    }
                    if (get_id.equals(22)) { //你感觉很容易衰弱和疲乏
                        depressionScores += ChanceEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setEasyDecline(key_id);
                    }
                    if (get_id.equals(23)) { //你的头脑跟以前一样清楚:
                        depressionScores += ChanceFanEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setMindClear(key_id);
                    }
                    if (get_id.equals(24)) { //你吃的跟以前一样多:
                        depressionScores += ChanceFanEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setEatGood(key_id);
                    }
                    if (get_id.equals(25)) {  //你觉得自己是个有用的人，有人需要我:
                        depressionScores += ChanceEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setUsefulPerson(key_id);
                    }
                    if (get_id.equals(26)) {  //你觉得“假如我消失了别人会过得更好”
                        depressionScores += ChanceEnums.getValueByKey(key_id);
                        psychologicalStatusQuestionnaire.setLiveBetter(key_id);
                    }
                    if (get_id.equals(27)) { //愿意接受专业的心理咨询/辅导吗?
                        psychologicalUestionnaireReport.setGetCounseling(WillingEnums.getValueByKey(key_id));
                        psychologicalStatusQuestionnaire.setGetCounseling(key_id);
                    }
                    if (get_id.equals(28)) { //觉得今年的新冠疫情对你的学业影响
                        covidLifeSocre += key_id + ",";
                        covidLifeSocreText = ImpactEnums.getNameByKey(key_id) + ",";
                        psychologicalStatusQuestionnaire.setAcademicImpact(key_id);
                    }
                    if (get_id.equals(29)) { //做得较多或者学着做的是(可选 1-3 项)
                        String lenarn_keys = getJsonArrayToString(choose);
                        covidLifeSocre += lenarn_keys + ",";
                        covidLifeSocreText = LearnDoEnums.getNameByKeys(lenarn_keys) + ",";

                        psychologicalStatusQuestionnaire.setScholarsDo(lenarn_keys);
                    }
                    if (get_id.equals(30)) { //新冠疫情给你带来了哪些感悟(可选 1-3 项):
                        String feel_keys = getJsonArrayToString(choose);
                        covidLifeSocre += feel_keys + ",";
                        covidLifeSocreText = FeelingEnums.getNameByKeys(feel_keys) + ",";

                        psychologicalStatusQuestionnaire.setCovidFeeling(feel_keys);
                    }
                    if (get_id.equals(31)) { //邮箱
                        psychologicalStatusQuestionnaire.setEmail(choose.getString(0));
                        psychologicalUestionnaireReport.setEmail(choose.getString(0));
                    }


                }

            }

            //疫情生活状态及影响

            if (StringUtils.isNotBlank(covidLifeSocre)) {
                covidLifeSocre = covidLifeSocre.substring(0, covidLifeSocre.length() - 1);
                covidLifeSocreText = covidLifeSocreText.substring(0, covidLifeSocreText.length() - 1);
            }

            psychologicalUestionnaireReport.setCovidLifeSocre(covidLifeSocre);
            psychologicalUestionnaireReport.setCovidLifeImpact(covidLifeSocreText);
            //焦虑得分
            psychologicalUestionnaireReport.setAnxietyScores((int) Math.ceil(anxietyScores * 2.5 * 1.2));
            //抑郁算分
            psychologicalUestionnaireReport.setDepressionScores((int) Math.ceil(depressionScores * 2.0 * 1.25));

            psychologicalStatusQuestionnaire.setCrTime(nowDate);

            this.save(psychologicalStatusQuestionnaire);
            log.info("插入心理问卷调查：{}", psychologicalUestionnaireReport);

            psychologicalUestionnaireReport.setCrTime(nowDate);
            psychologicalUestionnaireReport.setPsqId(psychologicalStatusQuestionnaire.getId());

            psychologicalUestionnaireReportService.save(psychologicalUestionnaireReport);

            log.info("插入心理问卷报告：{}", psychologicalUestionnaireReport);


            Long psy_id = psychologicalUestionnaireReport.getId();



//            if (StringUtils.isNotBlank(psychologicalUestionnaireReport.getEmail())) {
//                String context = "http://112.126.97.88:8080/#/result?id=" + psy_id + "&email=" + psychologicalUestionnaireReport.getEmail();
//                //                sendEmailUtils.sendSimpleMailMessge(purs.getEmail(),"心理问卷调查",context,from);
//
//                try {
//                    EmailParam emailParam = new EmailParam();
//                    emailParam.setUrl(context);
//                    emailParam.setCrTime(DateUtil.format(nowDate, "yyyy年MM月dd日"));
//                    emailParam.setToEmail(psychologicalUestionnaireReport.getEmail());
//                    String[] to = {psychologicalUestionnaireReport.getEmail()};
//                    sendEmailUtils.thymeleafSendEmail(from, to, "心理测评报告", emailParam, templatePath);
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//
//                log.info("用户id：{},邮箱:{},发送成功", psy_id, psychologicalUestionnaireReport.getEmail());
//            }
        } catch(Exception e){
            log.info("操作失败");
            e.printStackTrace();
        }
        return psychologicalUestionnaireReport.getId();
    }






    public  static  String getJsonArrayToString(JSONArray jsonArray){
        String str = "";
        for (int j = 0; j < jsonArray.size(); j++) {
            str += jsonArray.getString(j) + ",";
        }
        if(StringUtils.isNotBlank(str)){
           str = str.substring(0,str.length() - 1);
        }
        return str;

    }

    public static void main(String[] args) {
//        JSONArray jsonArray = new JSONArray();
//        String str = getJsonArrayToString(jsonArray);
        String str = ImpactEnums.getNameByKey(0);
        System.out.println(str);

//        String arrayStr = "[{id: 1,choose: [1],},{id: 2,choose: [3],},{id: 3,choose: [1, 2, 3]}]";
//        JSONArray jsonArray = JSONArray.fromObject(arrayStr);
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JSONObject jsonObject = JSONObject.fromObject(jsonArray.get(i).toString());
//            JSONArray choose = jsonObject.getJSONArray("choose");
//            System.out.println("choose = " + choose);
////            for (int j = 0; j < choose.size(); j++) {
////                System.out.println("choose.get(j) = " + choose.get(j));
////            }
//
//        }
    }

}
