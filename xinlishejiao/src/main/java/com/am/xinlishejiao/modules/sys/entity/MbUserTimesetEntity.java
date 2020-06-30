package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * helper预约时间设置
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("mb_user_timeset")
public class MbUserTimesetEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer setid;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Date setDate;
	/**
	 * 09:00-10:00
	 */
	private String setTime;
	/**
	 * 
	 */
	private String completeData;

}
