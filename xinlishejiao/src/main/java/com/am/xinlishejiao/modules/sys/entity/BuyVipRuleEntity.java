package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 购买会员规则表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("buy_vip_rule")
public class BuyVipRuleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 名称
	 */
	private String vipName;
	/**
	 * vip类型 1:月卡 2;季卡 3:年卡
	 */
	private Integer vipType;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 价格
	 */
	private BigDecimal vipPrice;

}
