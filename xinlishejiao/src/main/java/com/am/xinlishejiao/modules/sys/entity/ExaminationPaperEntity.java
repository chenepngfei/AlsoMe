package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 考题管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("examination_paper")
public class ExaminationPaperEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long examinationPaperId;
	/**
	 * 
	 */
	private String paperPic;
	/**
	 * 
	 */
	private String paperName;
	/**
	 * 
	 */
	private String paperDescribe;
	/**
	 * 
	 */
	private Long courseId;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Long chapterId;

}
