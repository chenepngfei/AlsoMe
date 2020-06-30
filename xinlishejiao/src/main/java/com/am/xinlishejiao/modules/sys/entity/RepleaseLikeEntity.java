package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 站内点赞,收藏表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("replease_like")
public class RepleaseLikeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long likeid;
	/**
	 * 0：提问 1：想法 2：树洞 3：课程 4:视频 5:广播6:测试7:卡片 8:help评论 9:视频评论 10:最新资讯
	 */
	private Integer targetType;
	/**
	 * 目标ID
	 */
	private Long targetId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Date operationTime;
	/**
	 * 0：点赞 1：收藏
	 */
	private Integer operationType;
	/**
	 * 课程章节ID
	 */
	private Long chapterId;

}
