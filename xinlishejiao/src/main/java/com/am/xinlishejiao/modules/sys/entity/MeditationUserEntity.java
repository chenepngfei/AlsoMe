package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户冥想记录表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("meditation_user")
public class MeditationUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long meditationUserId;
	/**
	 * 
	 */
	private Long meditationId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Date createTime;

}
