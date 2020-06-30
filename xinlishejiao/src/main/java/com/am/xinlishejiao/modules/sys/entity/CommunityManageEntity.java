package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 社区管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("community_manage")
public class CommunityManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long communityId;
	/**
	 * 
	 */
	private String communityName;
	/**
	 * 
	 */
	private String communityDescribe;
	/**
	 * 
	 */
	private Integer peopleNumber;
	/**
	 * 
	 */
	private Long createUser;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 社区类型 0:系统创建  1:用户创建
	 */
	private Integer communityType;
	/**
	 * 
	 */
	private Integer checkStatus;
	/**
	 * 0：待审核  1：审核通过 2：审核拒绝
	 */
	private String checkOpinion;
	/**
	 * 用户默认头像
	 */
	private String communityUserPicture;
	/**
	 * 用户默认昵称
	 */
	private String communityUserNickName;
	/**
	 * 
	 */
	private Long userId;

}
