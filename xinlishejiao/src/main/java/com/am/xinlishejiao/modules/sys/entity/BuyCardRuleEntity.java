package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 每日卡片抽取次数/匹配次数规则表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("buy_card_rule")
public class BuyCardRuleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Integer cardNumber;
	/**
	 * 
	 */
	private Integer price;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 1:购买每日卡片抽取次数规则 2:购买每日匹配次数规则
	 */
	private Integer ruleType;

}
