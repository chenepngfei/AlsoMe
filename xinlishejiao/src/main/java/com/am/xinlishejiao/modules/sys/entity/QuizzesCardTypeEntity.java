package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 卡片类别表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("quizzes_card_type")
public class QuizzesCardTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long quizzesTypeId;
	/**
	 * 
	 */
	private String quizzesTypeName;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 1: 测试题分类(弃用)     2:卡片分类
	 */
	private Integer type;
	/**
	 * 
	 */
	private String pictureUrl;
	/**
	 * 
	 */
	private Integer price;
	/**
	 * 
	 */
	private String quizzesCardDescribe;
	/**
	 * 完成测试数
	 */
	private Integer hasCardNum;

}
