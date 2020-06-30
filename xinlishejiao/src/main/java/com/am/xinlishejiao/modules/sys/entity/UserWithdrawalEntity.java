package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户提现记录表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
@Data
@TableName("user_withdrawal")
public class UserWithdrawalEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long rechargeId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Double withdrawalAmount;
	/**
	 * 1: 微信  2:银行卡
	 */
	private Integer withdrawalType;
	/**
	 * 
	 */
	private Date applyTime;
	/**
	 * 
	 */
	private Date checkTime;
	/**
	 * 0: 审核中  1:通过   2:拒绝
	 */
	private Integer withdrawalState;
	/**
	 * 余额
	 */
	private Double balance;
	/**
	 * 提现IP
	 */
	private String withdrawalIp;

}
