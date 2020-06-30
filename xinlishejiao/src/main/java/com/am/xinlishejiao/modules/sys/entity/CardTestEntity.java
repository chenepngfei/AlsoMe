package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 卡片管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("card_test")
public class CardTestEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long cardTestId;
	/**
	 * 
	 */
	private String cardName;
	/**
	 * 
	 */
	private Long quizzesTypeId;
	/**
	 * 
	 */
	private String cardInterpret;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String cardPic;
	/**
	 * 
	 */
	private String interpretPic;
	/**
	 * 0:停用 1:启用
	 */
	private Integer cardState;

}
