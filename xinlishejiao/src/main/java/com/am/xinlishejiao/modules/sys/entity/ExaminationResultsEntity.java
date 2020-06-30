package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 试题结果表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("examination_results")
public class ExaminationResultsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long examinationResultsId;
	/**
	 * 
	 */
	private Long examinationPaperId;
	/**
	 * 
	 */
	private String result;
	/**
	 * 
	 */
	private String fraction;

}
