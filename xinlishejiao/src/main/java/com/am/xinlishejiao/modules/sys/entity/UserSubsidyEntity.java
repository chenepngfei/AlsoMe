package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户津贴设置表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
@Data
@TableName("user_subsidy")
public class UserSubsidyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long userSubsidyId;
	/**
	 * 等级
	 */
	private Integer level;
	/**
	 * 津贴金额
	 */
	private Double subsidyNumber;
	/**
	 * 帮助时长
	 */
	private Integer helpTime;
	/**
	 * 扣除金币
	 */
	private Integer deductGold;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date editTime;

}
