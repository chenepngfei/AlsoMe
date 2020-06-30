package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 求助历史记录表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("seek_help_history")
public class SeekHelpHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Long helpUserId;
	/**
	 * 
	 */
	private Long seekHelpId;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 聊天开始时间
	 */
	private Date beginTime;
	/**
	 * 聊天结束时间
	 */
	private Date endTime;
	/**
	 * 0:聊天中 1:已结束未支付 2:已结束已支付
	 */
	private Integer state;
	/**
	 * 1:30分钟 2:60分钟
	 */
	private Integer timeLength;

}
