package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台管理员表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("auth_admin")
public class AuthAdminEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String tel;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String avatar;
	/**
	 * 性别；0：保密，1：男；2：女
	 */
	private Integer sex;
	/**
	 * 
	 */
	private String lastLoginIp;
	/**
	 * 
	 */
	private Date lastLoginTime;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 用户状态 0：禁用； 1：正常 ；2：未验证
	 */
	private Integer status;

}
