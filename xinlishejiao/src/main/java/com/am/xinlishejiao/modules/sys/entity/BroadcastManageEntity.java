package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 每日广播表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("broadcast_manage")
public class BroadcastManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long broadcastId;
	/**
	 * 
	 */
	private String broadcastName;
	/**
	 * 
	 */
	private String broadcastPic;
	/**
	 * 广播语音文件地址
	 */
	private String broadcastFileUrl;
	/**
	 * 
	 */
	private Integer commentNumber;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 广播时长
	 */
	private String timeLenth;
	/**
	 * 文件名称
	 */
	private String fileName;

}
