package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 金币、余额资金变动记录表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
@Data
@TableName("user_possession")
public class UserPossessionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long recordid;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Double amount;
	/**
	 * 
	 */
	private Date recordtime;
	/**
	 * 0：金币 1：余额  2:收益
	 */
	private Integer recordtype;
	/**
	 * 
	 */
	private String disbursetype;
	/**
	 * 
	 */
	private String recordsource;
	/**
	 * 交易金额
	 */
	private String transactionAmount;
	/**
	 * 来源ID
	 */
	private Long sourceId;
	/**
	 * 0:收入 1:支出 2:充值
	 */
	private Integer operationType;

}
