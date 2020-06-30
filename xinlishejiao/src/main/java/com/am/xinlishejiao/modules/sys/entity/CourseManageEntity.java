package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("course_manage")
public class CourseManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long courseId;
	/**
	 * 
	 */
	private String coursePic;
	/**
	 * 
	 */
	private String courseTitle;
	/**
	 * 
	 */
	private Long courseCategoryId;
	/**
	 * 
	 */
	private Integer price;
	/**
	 * 
	 */
	private Integer studyNumber;
	/**
	 * 
	 */
	private Integer commentNumber;
	/**
	 * 
	 */
	private Integer likeNumber;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String courseSynopsis;
	/**
	 * 
	 */
	private Integer userType;
	/**
	 * 
	 */
	private String applicableLevel;

}
