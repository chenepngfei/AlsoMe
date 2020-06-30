package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程/广播/视频评论表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("find_comment")
public class FindCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long findCommentId;
	/**
	 * 
	 */
	private Long targetId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 3: 课程 4:视频 5: 广播  10:资讯
	 */
	private Integer targetType;
	/**
	 * 课程章节id
	 */
	private Long chapterId;

}
