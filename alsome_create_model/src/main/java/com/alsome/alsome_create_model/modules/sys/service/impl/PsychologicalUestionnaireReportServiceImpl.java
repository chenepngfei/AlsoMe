package com.alsome.alsome_create_model.modules.sys.service.impl;

import cn.hutool.core.date.DateUtil;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;
import com.alsome.alsome_create_model.common.utils.SendEmailUtils;
import com.alsome.alsome_create_model.modules.sys.dao.PsychologicalUestionnaireReportDao;
import com.alsome.alsome_create_model.modules.sys.entity.EmailParam;
import com.alsome.alsome_create_model.modules.sys.entity.PsychologicalUestionnaireReport;
import com.alsome.alsome_create_model.modules.sys.service.PsychologicalStatusQuestionnaireService;
import com.alsome.alsome_create_model.modules.sys.service.PsychologicalUestionnaireReportService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("psychologicalUestionnaireReportService")
@Slf4j
public class PsychologicalUestionnaireReportServiceImpl extends ServiceImpl<PsychologicalUestionnaireReportDao, PsychologicalUestionnaireReport> implements PsychologicalUestionnaireReportService {

    @Autowired
    PsychologicalStatusQuestionnaireService psychologicalStatusQuestionnaireService;
    @Value("${spring.mail.username}")
    private String from;
    @Value("${templatePath}")
    private String templatePath;
    @Autowired
    private SendEmailUtils sendEmailUtils;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PsychologicalUestionnaireReport> page = this.page(
                new Query<PsychologicalUestionnaireReport>().getPage(params),
                new QueryWrapper<PsychologicalUestionnaireReport>()
        );

        return new PageUtils(page);
    }


    @Override
    public List<PsychologicalUestionnaireReport> queryListByEmail(PsychologicalUestionnaireReport pur) {
        Date nowDate = DateUtil.yesterday();

//        boolean idFlag = false;
//        boolean emailFlag = false;
//        if(pur != null){
//            if(pur.getId() != null && pur.getId() > 0){
//                idFlag = true;
//            }
//            if(StringUtils.isNotBlank(pur.getEmail())){
//                emailFlag = true;
//            }
//
//        }

        List<PsychologicalUestionnaireReport> list = this.list(new QueryWrapper<PsychologicalUestionnaireReport>()
//                .eq(idFlag,"id", pur.getId())
//                .eq(emailFlag ,"email", pur.getEmail())
                .eq("is_send",0).le("cr_time",DateUtil.endOfDay(nowDate))
//                .ge("cr_time",DateUtil.beginOfDay(nowDate))
//                .le("cr_time",DateUtil.endOfDay(nowDate))
        );

        if(CollectionUtils.isNotEmpty(list)){
            for(PsychologicalUestionnaireReport purs : list){
                String context = "http://112.126.97.88:8080/#/result?id="+purs.getId()+"&email=" +purs.getEmail();
//                sendEmailUtils.sendSimpleMailMessge(purs.getEmail(),"心理问卷调查",context,from);

                try {
                    EmailParam emailParam = new EmailParam();
                    emailParam.setUrl(context);
                    emailParam.setCrTime(DateUtil.format(purs.getCrTime(), "yyyy年MM月dd日"));
                    emailParam.setToEmail(purs.getEmail());
                    String [] to={purs.getEmail()};
                    sendEmailUtils.thymeleafSendEmail(from, to, "心理测评报告", emailParam, templatePath);

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                PsychologicalUestionnaireReport psy = new PsychologicalUestionnaireReport();
                psy.setId(purs.getId());
                psy.setIsSend(1);
                this.updateById(psy);

                log.info("已发送成功{},修改状态:{}",purs.getId(),1);

                log.info("用户id：{},邮箱:{},发送成功",purs.getId(),purs.getEmail());


            }
        }

        return list;
    }


    @Override
    public PsychologicalUestionnaireReport getPsychologicalUestionnaireReport(PsychologicalUestionnaireReport psychologicalUestionnaireReport){
        PsychologicalUestionnaireReport one = this.getOne(
                new QueryWrapper<PsychologicalUestionnaireReport>()
                        .eq(psychologicalUestionnaireReport.getId() != null && psychologicalUestionnaireReport.getId() > 0,"id", psychologicalUestionnaireReport.getId())
                        .eq(StringUtils.isNotBlank(psychologicalUestionnaireReport.getEmail()),"email", psychologicalUestionnaireReport.getEmail())

                );

        if(one != null){
            return  one;
        }

        return null;

    }

    public static void main(String[] args) {

        Date now = new Date();
//        //一天的开始，结果：2017-03-01 00:00:00
//        Date beginOfDay = DateUtil.beginOfDay(now);
//
//        //一天的结束，结果：2017-03-01 23:59:59
//        Date endOfDay = DateUtil.endOfDay(now);
//
//        System.out.println(beginOfDay +"jjj" + endOfDay);
        String format = DateUtil.format(now, "yyyy年MM月dd日");
        System.out.println(format);


    }


}
