package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 反馈管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("feedback_manage")
public class FeedbackManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long feedbackId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private String userPhone;
	/**
	 * 
	 */
	private String feedbackContent;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 0:未回复   1:已回复
	 */
	private Integer replyState;
	/**
	 * 
	 */
	private String replyContent;

}
