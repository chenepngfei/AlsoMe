package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 试题管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("examination_questions")
public class ExaminationQuestionsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long examinationQuestionsId;
	/**
	 * 
	 */
	private String questionsName;
	/**
	 * 
	 */
	private String questionsDescribe;
	/**
	 * 
	 */
	private String answer;
	/**
	 * 
	 */
	private Long examinationPaperId;
	/**
	 * 1:单选题 2:多选题 3:简单题
	 */
	private Integer type;
	/**
	 * 
	 */
	private Long chapterId;

}
