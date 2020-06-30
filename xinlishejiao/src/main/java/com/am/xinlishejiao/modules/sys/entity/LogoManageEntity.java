package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * logo管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("logo_manage")
public class LogoManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long logoId;
	/**
	 * 
	 */
	private String logoName;
	/**
	 * 
	 */
	private String logoUrl;
	/**
	 * 
	 */
	private Date createTime;

}
