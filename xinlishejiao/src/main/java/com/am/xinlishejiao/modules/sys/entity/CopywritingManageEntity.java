package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文本管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("copywriting_manage")
public class CopywritingManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long copywritingId;
	/**
	 * 1：用户注册；2：关于我们；3：帮助；4：任务说明 5:会员权益说明   6:充值说明 7.提现微信规则 8.提现银行卡规则 9.金币说明 10.金币兑换说明
	 */
	private Integer copywritingType;
	/**
	 * 
	 */
	private String logoUrl;
	/**
	 * 
	 */
	private String copywritingName;
	/**
	 * 
	 */
	private String copywritingContent;
	/**
	 * 
	 */
	private String contact;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 类型名
	 */
	private String typeName;

}
