package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 关键词搜索表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("sys_key_word")
public class SysKeyWordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long keyWordId;
	/**
	 * 
	 */
	private String keyWord;
	/**
	 * 0:测试 1:课程2:视频 3:社区 4:帮助 5:资讯 标签
	 */
	private Long moudleId;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 0:停用  1:启用
	 */
	private Integer state;
	/**
	 * 序号
	 */
	private Integer serialNumber;

}
