package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 树洞管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
@Data
@TableName("tree_hole")
public class TreeHoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long treeHoleId;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 0: 不公开 1:公开
	 */
	private Integer isPublic;
	/**
	 * 0:
	 */
	private Integer state;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Long communityId;
	/**
	 * 是否草稿 0:否 1:是
	 */
	private Integer isDraft;

}
