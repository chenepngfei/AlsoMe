package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统消息表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("sys_message")
public class SysMessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long messageId;
	/**
	 * 
	 */
	private String messagePic;
	/**
	 * 
	 */
	private String messageIntroduction;
	/**
	 * 
	 */
	private String messageContent;
	/**
	 * 
	 */
	private Integer messageType;
	/**
	 * 
	 */
	private String messageName;
	/**
	 * 
	 */
	private Integer userType;
	/**
	 * 
	 */
	private Date sendTime;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date editeTime;
	/**
	 * 0:待发送 1:已发送
	 */
	private Integer sendState;
	/**
	 * 0:不是全部 1：全部
	 */
	private Integer isAll;

}
