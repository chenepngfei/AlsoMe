package com.alsome.alsome_create_model.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 心理状况调查
 *
 * @author cpf
 * @email chenpfmail@163.com
 * @date 2020-06-08 15:24:09
 */
@Data
@TableName("psychological_survey")
public class PsychologicalSurvey implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long id;
	/**
	 * 焦虑自评得分
	 */
	private Integer anxietyScores;
	/**
	 * 焦虑情况表现
	 */
	private String anxietyPerformance;
	/**
	 * 抑郁自评得分
	 */
	private Integer depressionScores;
	/**
	 * 抑郁状况表现
	 */
	private String depressionPerformance;
	/**
	 * 压力感受得分
	 */
	private String psychologicalScores;
	/**
	 * 压力来源
	 */
	private String psychologicalSource;
	/**
	 * 报告单位
	 */
	private Long reportingUnitId;
	/**
	 * 报告来源
	 */
	private Long reportingSourceId;
	/**
	 * 问卷编号
	 */
	private String questionnaireNumber;
	/**
	 * 学习生活满意度
	 */
	private String lifeSatisfaction;
	/**
	 *总体状况及专家建议
	 */
	private String generalAdvice;
	/**
	 *温馨提示
	 */
	private String warmPrompt;

	/**
	 * 报告日期
	 */
	private Date crtime;

}
