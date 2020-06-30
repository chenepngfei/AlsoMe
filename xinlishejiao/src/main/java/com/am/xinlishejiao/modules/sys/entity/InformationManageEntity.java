package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 资讯管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("information_manage")
public class InformationManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long informationId;
	/**
	 * 资讯类型
	 */
	private Integer informationType;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String informationPic;
	/**
	 * 
	 */
	private String videoUrl;
	/**
	 * 
	 */
	private String content;
	/**
	 * 阅读数
	 */
	private Integer redNumber;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 评论数
	 */
	private Integer commentNumber;
	/**
	 * 
	 */
	private Date publishTime;
	/**
	 * 
	 */
	private Date editTime;
	/**
	 * 视频点播ID
	 */
	private String openVideoId;

}
