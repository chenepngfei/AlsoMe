package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 申诉表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("appeal_manager")
public class AppealManagerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long appealId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private String appealReason;
	/**
	 * 
	 */
	private Long expertId;
	/**
	 * 
	 */
	private Double appealMoney;
	/**
	 * 0:预约 1:求助
	 */
	private Integer category;
	/**
	 * 对话时间
	 */
	private Date talkTime;
	/**
	 * 申述时间
	 */
	private Date appealTime;
	/**
	 * 0:未处理 1:已处理
	 */
	private Integer handleState;
	/**
	 * 
	 */
	private String handleWay;
	/**
	 * 预约ID
	 */
	private Long reserveId;

}
