package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户预约专家记录表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("sys_reserve")
public class SysReserveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long reserveId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Long expertId;
	/**
	 * 
	 */
	private String reserveLength;
	/**
	 * 
	 */
	private Date reserveDate;
	/**
	 * 
	 */
	private Double reserveMoney;
	/**
	 * -1:未支付 0:未完成  1:已完成 2:申诉  3:已退款
	 */
	private Integer reserveState;
	/**
	 * 
	 */
	private Date orderTime;
	/**
	 * 
	 */
	private Long seekHelpId;
	/**
	 * 预约描述
	 */
	private String reserveDescribe;
	/**
	 * 
	 */
	private String reserveTime;
	/**
	 * 60分钟整体数据
	 */
	private String reserveTimeResult;

}
