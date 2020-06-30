package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 全球地区库，采集自腾讯QQ国内+国际版.ADD.JENA.20141221
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("to_location")
public class ToLocationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 父ID
	 */
	private Integer pid;
	/**
	 * 路径
	 */
	private String path;
	/**
	 * 层级
	 */
	private Integer level;
	/**
	 * 中文名称
	 */
	private String name;
	/**
	 * 英文名称
	 */
	private String nameEn;
	/**
	 * 中文拼音
	 */
	private String namePinyin;
	/**
	 * 代码
	 */
	private String code;

}
