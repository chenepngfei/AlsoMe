package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 站内评论回复表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("replease_reply")
public class RepleaseReplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long replyid;
	/**
	 * 
	 */
	private Long commentid;
	/**
	 * 0：提问 1：想法 2：树洞 3：课程 4:视频 5:广播6:测试7:卡片 8:help评论 9:视频评论 10:最新资讯
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
	private Long byUserId;
	/**
	 * 
	 */
	private String replyDesc;
	/**
	 * 
	 */
	private Date replyTime;

}
