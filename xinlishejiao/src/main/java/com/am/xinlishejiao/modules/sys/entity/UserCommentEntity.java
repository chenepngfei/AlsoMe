package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论用户表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("user_comment")
public class UserCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long userCommentId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Long beUserId;
	/**
	 * 
	 */
	private String commentContent;
	/**
	 * 
	 */
	private Integer level;
	/**
	 * 
	 */
	private Date createTime;

}
