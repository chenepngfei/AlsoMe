package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 匹配设置表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("mate_manage")
public class MateManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long mateId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Integer mateNumber;
	/**
	 * 
	 */
	private Integer payNumber;
	/**
	 * 
	 */
	private Integer matePeopleNumber;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 0:全部 1:男 2:女
	 */
	private Integer mateSex;
	/**
	 * 国家
	 */
	private String mateCountry;
	/**
	 * 城市
	 */
	private String mateCity;
	/**
	 * 用户类型
	 */
	private Integer userType;
	/**
	 * 爱好
	 */
	private String hobby;
	/**
	 * 是否允许匹配 0:否 1:是
	 */
	private Integer isMate;

}
