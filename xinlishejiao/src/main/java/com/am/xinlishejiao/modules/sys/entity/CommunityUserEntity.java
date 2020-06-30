package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 社区用户表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("community_user")
public class CommunityUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long communityUserId;
	/**
	 * 
	 */
	private Long communityId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 0：群主 1：成员
	 */
	private Integer userType;

}
