package com.alsome.alsome_create_model.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 心理调研问卷结果报告表
 * 
 * @author cpf
 * @email chenpfmail@163.com
 * @date 2020-06-13 12:23:29
 */
@Data
@TableName("psychological_uestionnaire_report")
public class PsychologicalUestionnaireReport implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 心理状态调查问卷表，关联id
	 */
	private Long psqId;
	/**
	 * 焦虑得分
	 */
	private Integer anxietyScores;
	/**
	 * 抑郁自评算分
	 */
	private Integer depressionScores;
	/**
	 * 压力感受得分
	 */
	private String psychologicalScores;
	/**
	 * 压力来源
	 */
	private String psychologicalSource;
	/**
	 * 情绪/心情影响因素
	 */
	private String emotionalImpact;
	/**
	 * 学校
	 */
	private Integer likeSchool;
	/**
	 * 专业
	 */
	private Integer likeProfessional;
	/**
	 * 是否接受心理咨询
	 */
	private Integer getCounseling;
	/**
	 * 疫情生活及影响得分
	 */
	private String covidLifeSocre;
	/**
	 * 疫情生活及影响
	 */
	private String covidLifeImpact;
	/**
	 * 创建时间
	 */
	private Date crTime;

}
