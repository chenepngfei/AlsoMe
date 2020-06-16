package com.alsome.alsome_create_model.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 中国大学生心理状态调查问卷
 * 
 * @author cpf
 * @email chenpfmail@163.com
 * @date 2020-06-13 12:23:29
 */
@Data
@TableName("psychological_status_questionnaire")
public class PsychologicalStatusQuestionnaire implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 现在在读
	 */
	private Integer reading;
	/**
	 * 攻读的学位
	 */
	private Integer degree;
	/**
	 * 专业
	 */
	private String professionals;
	/**
	 * 地址位置
	 */
	private Integer address;
	/**
	 * 喜欢现在学校吗
	 */
	private Integer likeSchool;
	/**
	 * 喜欢你现在的专业
	 */
	private Integer likeProfessional;
	/**
	 * 学习压力多大
	 */
	private Integer academicPressure;
	/**
	 * 压力主要来源 
	 */
	private String pressureSource;
	/**
	 * 情绪受那些方面影响
	 */
	private String emotionalImpact;
	/**
	 * 觉得自己比以前更容易紧张或起急
	 */
	private Integer nervousAnxious;
	/**
	 * 会无缘无故感到害怕
	 */
	private Integer beAfraid;
	/**
	 * 容易心烦意乱或心跳加快
	 */
	private Integer upsetHeartbeat;
	/**
	 * 觉得一切都好，也不会发生什么不幸
	 */
	private Integer notMisfortune;
	/**
	 * 因为头痛(头晕)、劲痛和背痛而苦恼
	 */
	private Integer headachePain;
	/**
	 * 因为胃疼和消化不良而苦恼
	 */
	private Integer stomachUpset;
	/**
	 * 很容易入睡并且一夜睡的很好
	 */
	private Integer sleepWell;
	/**
	 * 坐卧不安，难以保持平静
	 */
	private Integer notCalm;
	/**
	 * 感到情绪低落，沮丧，郁闷
	 */
	private Integer badMood;
	/**
	 * 要哭或想哭
	 */
	private Integer wantCry;
	/**
	 * 你与他人接触是感到愉快
	 */
	private Integer feelHappy;
	/**
	 * 你感觉很容易衰弱和疲乏
	 */
	private Integer easyDecline;
	/**
	 * 你的头脑跟以前一样清楚
	 */
	private Integer mindClear;
	/**
	 * 你吃的跟以前一样多
	 */
	private Integer eatGood;
	/**
	 * 觉得自己是个有用的人，有人需要我
	 */
	private Integer usefulPerson;
	/**
	 * 你觉得“假如我消失了别人会过得更好”
	 */
	private Integer liveBetter;
	/**
	 * 如果你需要较大的情绪困扰或心理状态不好，你会愿意接受专业的心理咨询/辅导吗
	 */
	private Integer getCounseling;
	/**
	 * 你觉得今年的新冠一起对你的学业影响
	 */
	private Integer academicImpact;
	/**
	 * 在今年的疫情宅家生活中，你做的较多或者学者做的是
	 */
	private String scholarsDo;
	/**
	 * 新冠疫情给你带来了哪些感悟
	 */
	private String covidFeeling;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 创建日期
	 */
	private Date crTime;

}
