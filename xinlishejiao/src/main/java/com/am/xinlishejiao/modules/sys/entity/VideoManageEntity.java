package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 视频管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
@Data
@TableName("video_manage")
public class VideoManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long videoId;
	/**
	 * 
	 */
	private String videoName;
	/**
	 * 
	 */
	private String videoUrl;
	/**
	 * 
	 */
	private String videoTime;
	/**
	 * 0:常规 1:求助
	 */
	private Integer videoType;
	/**
	 * 
	 */
	private String userName;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Integer likeNumber;
	/**
	 * 
	 */
	private Integer shareNumber;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 0:非精华 1:精华
	 */
	private Integer isImportant;
	/**
	 * 封面图
	 */
	private String videoPic;
	/**
	 * 视频描述
	 */
	private String videoDescribe;
	/**
	 * 是否草稿 0:否 1:是
	 */
	private Integer isDraft;
	/**
	 * 视频高度
	 */
	private Double height;
	/**
	 * 视频宽度
	 */
	private Double width;
	/**
	 * 0:未帮助 1:已帮助 2:进行中
	 */
	private Integer videoState;
	/**
	 * 帮助者ID
	 */
	private Long helperUserId;
	/**
	 * 0:未帮助 1:已帮助
	 */
	private Integer helpState;

}
