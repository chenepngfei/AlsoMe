package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试题管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("quizzes_manage")
public class QuizzesManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long quizzesId;
	/**
	 * 
	 */
	private String quizzesUrl;
	/**
	 * 
	 */
	private String quizzesTitle;
	/**
	 * 
	 */
	private String quizzesContent;
	/**
	 * 
	 */
	private Long quizzesTypeId;
	/**
	 * 
	 */
	private Integer quizzesPrice;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 0:启用 1:停用
	 */
	private Integer useStatus;
	/**
	 * 0：未删除 1：已删除
	 */
	private Integer useDel;
	/**
	 * 
	 */
	private Integer hasTestNun;
	/**
	 * 
	 */
	private String quizzesQuestions;
	/**
	 * 
	 */
	private String quizzesResult;

}
