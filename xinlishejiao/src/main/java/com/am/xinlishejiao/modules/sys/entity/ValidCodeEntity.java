package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 验证码表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
@Data
@TableName("valid_code")
public class ValidCodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long validCodeId;
	/**
	 * 
	 */
	private String userPhoe;
	/**
	 * 
	 */
	private String validCode;
	/**
	 * 
	 */
	private String codeId;
	/**
	 * 
	 */
	private Integer codeType;
	/**
	 * 
	 */
	private Date useCode;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String userMailbox;

}
