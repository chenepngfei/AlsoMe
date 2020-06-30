package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 求助管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("sys_seek_help")
public class SysSeekHelpEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long seekHelpId;
	/**
	 * 
	 */
	private String seekHelNumber;
	/**
	 * 求助人
	 */
	private Long userId;
	/**
	 * 
	 */
	private Long seekHelpTypeId;
	/**
	 * 0:文字
	 */
	private Integer showType;
	/**
	 * 
	 */
	private String seekHelpTitle;
	/**
	 * 
	 */
	private String seekContent;
	/**
	 * 0:未帮助 1:已帮助 2:进行中
	 */
	private Integer seekState;
	/**
	 * 0:不加急 1:加急
	 */
	private Integer isUrgent;
	/**
	 * 
	 */
	private Integer urgentGrade;
	/**
	 * 
	 */
	private Integer urgentGold;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 0:未推荐  1:推荐
	 */
	private Integer isRecommend;
	/**
	 * 
	 */
	private Long helpUserId;
	/**
	 * 打赏金币
	 */
	private Integer rewardGold;
	/**
	 * 视频封面图
	 */
	private String videoPic;
	/**
	 * 视频描述
	 */
	private String seekDescribe;

}
