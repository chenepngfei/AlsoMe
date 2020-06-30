package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 专家证件资质表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
@Data
@TableName("user_certificates")
public class UserCertificatesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long userCertificatesId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 证件照路径
	 */
	private String certificatesUrl;

}
