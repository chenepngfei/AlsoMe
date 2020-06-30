package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 每日冥想管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("meditation_manage")
public class MeditationManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long meditationId;
	/**
	 * 
	 */
	private String meditationName;
	/**
	 * 
	 */
	private String meditationPic;
	/**
	 * 
	 */
	private String musicName;
	/**
	 * 
	 */
	private String musicUrl;
	/**
	 * 
	 */
	private String meditationDescrible;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 文件时长
	 */
	private String duration;

}
