package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户课程考试结果表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
@Data
@TableName("user_examination_results")
public class UserExaminationResultsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 
	 */
	private Long courseId;
	/**
	 * 
	 */
	private Long chapterId;
	/**
	 * 考题ID
	 */
	private Long examinationPaperId;
	/**
	 * 
	 */
	private String answer;
	/**
	 * 考试等级
	 */
	private String grade;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 0:未考试 1:已考试 2:未通过
	 */
	private Integer state;
	/**
	 * 简答题答案
	 */
	private String answerText;
	/**
	 * 考试剩余次数
	 */
	private Integer examinationNum;
	/**
	 * 考试详情
	 */
	private String answerDetail;
	/**
	 * 简答题题目
	 */
	private String questionsName;
	/**
	 * 试题结果
	 */
	private String questionsResult;

}
