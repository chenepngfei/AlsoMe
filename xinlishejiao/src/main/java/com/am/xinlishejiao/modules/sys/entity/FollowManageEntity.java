package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户关注表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("follow_manage")
public class FollowManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long followManageId;
	/**
	 * 关注人
	 */
	private Long followUserId;
	/**
	 * 被关注人
	 */
	private Long beFollowUserId;
	/**
	 * 添加时间
	 */
	private Date createTime;

}
