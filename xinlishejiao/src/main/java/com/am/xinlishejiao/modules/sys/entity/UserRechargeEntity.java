package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户充值记录表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
@Data
@TableName("user_recharge")
public class UserRechargeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long rechargeId;
	/**
	 * 订单号
	 */
	private String orderNumber;
	/**
	 * 三方充值单号
	 */
	private String outtradeno;
	/**
	 * 充值人
	 */
	private Long userId;
	/**
	 * 0：充值金币  1：充值余额
	 */
	private Integer rechargeType;
	/**
	 * 
	 */
	private BigDecimal rechargeAmount;
	/**
	 * 
	 */
	private Date rechargeTime;
	/**
	 * 0：余额支付 1：微信 2:支付宝
	 */
	private Integer payType;
	/**
	 * 0：待支付 1：已支付
	 */
	private Integer payStatus;
	/**
	 * 
	 */
	private Date payTime;
	/**
	 * 
	 */
	private BigDecimal payPrice;
	/**
	 * 充值方式
	 */
	private Integer rechargeWay;

}
