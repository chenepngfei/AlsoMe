package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 提问/想法/树洞 /最新资讯评论表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("replease_comment")
public class RepleaseCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long commentid;
	/**
	 * 0：提问 1：想法 2：树洞 10:最新资讯
	 */
	private Integer targetType;
	/**
	 * 对应type类型
	 */
	private Long targetId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private String commentDesc;
	/**
	 * 
	 */
	private Date commentTime;
	/**
	 * 
	 */
	private Integer bestcomment;
	/**
	 * 0:否 1:是
	 */
	private Integer isDraft;

}
