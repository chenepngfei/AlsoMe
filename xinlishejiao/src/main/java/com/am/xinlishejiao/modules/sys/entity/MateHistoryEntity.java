package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 匹配历史表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("mate_history")
public class MateHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long mateHistoryId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Long mateUserId;
	/**
	 * 
	 */
	private String mateDegree;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Long mateId;
	/**
	 * 
	 */
	private Long mateRecordId;

}
