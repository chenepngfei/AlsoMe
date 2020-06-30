package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色模块规则表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("auth_permission_rule")
public class AuthPermissionRuleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 角色模块规则父ID
	 */
	private Integer pid;
	/**
	 * 
	 */
	private Integer isLeaf;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String title;
	/**
	 * 角色模块规则状态
	 */
	private Integer status;
	/**
	 * 
	 */
	private String conditions;
	/**
	 * 排序
	 */
	private Integer listorder;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;

}
