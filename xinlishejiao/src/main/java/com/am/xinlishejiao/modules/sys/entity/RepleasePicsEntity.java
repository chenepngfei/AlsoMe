package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 想法,树洞图片管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("replease_pics")
public class RepleasePicsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long picId;
	/**
	 * 类型
	 */
	private Integer targetType;
	/**
	 * 目标ID
	 */
	private Long targetId;
	/**
	 * 图片地址
	 */
	private String picUrl;

}
