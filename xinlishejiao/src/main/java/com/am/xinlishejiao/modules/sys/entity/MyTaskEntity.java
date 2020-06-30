package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户任务表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("my_task")
public class MyTaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long myTaskId;
	/**
	 * 
	 */
	private Long taskId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 完成进度
	 */
	private String completionDegree;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date editTime;
	/**
	 * 0:未开始 1:进行中 2:已完成
	 */
	private Integer state;
	/**
	 * 任务等级
	 */
	private Integer taskLevel;
	/**
	 * 1: 发布求助 2:匹配 3:测试 4:读一本书 5:课程 6:发布视频 7:创建或加入社区 8:动画引导 9:无偿帮助
	 */
	private Integer taskType;

}
