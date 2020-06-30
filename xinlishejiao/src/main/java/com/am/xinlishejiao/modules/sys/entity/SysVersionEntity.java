package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统版本管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("sys_version")
public class SysVersionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer sysversionid;
	/**
	 * 
	 */
	private String versionexplain;
	/**
	 * 
	 */
	private Date versiontime;
	/**
	 * 
	 */
	private String versionurl;
	/**
	 * 
	 */
	private String versionlowest;
	/**
	 * 
	 */
	private String version;
	/**
	 * 
	 */
	private String versionname;
	/**
	 * 1:强制 0:非强制
	 */
	private String versionupdate;
	/**
	 * 订单服务费
	 */
	private Double serviceCharge;

}
