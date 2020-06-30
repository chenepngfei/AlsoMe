package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 任务管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("task_manage")
public class TaskManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long taskId;
	/**
	 * 
	 */
	private String taskName;
	/**
	 * 1:seeker任务 2：helper任务
	 */
	private Integer taskRole;
	/**
	 * 
	 */
	private Integer taskType;
	/**
	 * 
	 */
	private String taskPic;
	/**
	 * 
	 */
	private String taskDescrible;
	/**
	 * 
	 */
	private Integer taskNumber;
	/**
	 * 任务等级123456级
	 */
	private Integer taskLevel;
	/**
	 * 1: 发布求助 2:匹配 3:测试 4:读一本书 5:课程 6:发布视频 7:创建或加入社区 8:动画引导 9:无偿帮助
	 */
	private Integer targetType;

}
