package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 匹配记录表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("mate_record")
public class MateRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long mateRecordId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 选中人ID
	 */
	private Long beUserId;

}
