package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户消息表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
@Data
@TableName("user_message")
public class UserMessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long userMessageId;
	/**
	 * 
	 */
	private Long messageId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 消息状态 -1:待发送 0:未删除 1:已删除
	 */
	private Integer state;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 *  0:未读 1:已读
	 */
	private Integer readState;
	/**
	 * 消息标题
	 */
	private String messageTitle;
	/**
	 * 消息内容
	 */
	private String messageContent;

}
