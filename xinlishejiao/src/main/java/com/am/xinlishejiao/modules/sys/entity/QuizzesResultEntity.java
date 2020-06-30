package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户测试结果表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("quizzes_result")
public class QuizzesResultEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long quizzesResultId;
	/**
	 * 测试题ID
	 */
	private Long quizzesId;
	/**
	 * 测试结果
	 */
	private String quizzesResult;
	/**
	 * 测试用户
	 */
	private Long userId;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 1:测试题 2:卡片测试
	 */
	private Integer type;
	/**
	 * 卡片类型
	 */
	private Long cardTypeId;
	/**
	 * 
	 */
	private String quizzesQuestions;

}
