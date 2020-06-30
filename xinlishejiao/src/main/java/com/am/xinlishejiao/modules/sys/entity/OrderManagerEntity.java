package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 购买会员订单记录表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("order_manager")
public class OrderManagerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long orderId;
	/**
	 * 
	 */
	private Long sourceId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private String orderNumber;
	/**
	 * 
	 */
	private String outTradeNo;
	/**
	 * 2:购买会员
	 */
	private Integer orderType;
	/**
	 * 0:未支付 1:已支付
	 */
	private Integer payState;
	/**
	 * 
	 */
	private Date payTime;
	/**
	 * 
	 */
	private Date orderTime;
	/**
	 * 
	 */
	private BigDecimal orderPrice;
	/**
	 * 1:账户余额 2:微信 3:支付宝
	 */
	private Integer payType;

}
