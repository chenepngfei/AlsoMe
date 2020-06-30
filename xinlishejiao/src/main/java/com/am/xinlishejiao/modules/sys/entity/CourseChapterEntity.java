package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程章节表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("course_chapter")
public class CourseChapterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long chapterId;
	/**
	 * 
	 */
	private Long courseId;
	/**
	 * 
	 */
	private Integer chapterNumber;
	/**
	 * 
	 */
	private String linkUrl;
	/**
	 * 
	 */
	private String courseName;

}
