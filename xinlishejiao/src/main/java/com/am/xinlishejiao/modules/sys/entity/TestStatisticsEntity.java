package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试题统计管理表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("test_statistics")
public class TestStatisticsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long testStatisticsId;
	/**
	 * 
	 */
	private Long quizzesId;
	/**
	 * 测试答案
	 */
	private String quizzesAnwser;
	/**
	 * 测试结果
	 */
	private String quizzesResult;

}
