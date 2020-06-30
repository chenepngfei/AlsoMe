package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户购买课程表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("my_course")
public class MyCourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long myCourseId;
	/**
	 * 
	 */
	private Long courseId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 学习状态 0:未学完 1:已学完
	 */
	private Integer learningState;

}
