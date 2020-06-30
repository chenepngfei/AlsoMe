package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 提问/想法通用表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("dialogue")
public class DialogueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long dialogueId;
	/**
	 * 
	 */
	private String askContent;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Long communityId;
	/**
	 * 0:
	 */
	private Integer awardGold;
	/**
	 * 
	 */
	private Integer answerNumber;
	/**
	 * 
	 */
	private Integer likeNumber;
	/**
	 * 0:未结束   1:已结束
	 */
	private Integer state;
	/**
	 * 0:
	 */
	private Integer isDel;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 0:
	 */
	private Integer isRecommend;
	/**
	 * 0：已发布 1：草稿箱
	 */
	private Integer releaseStatus;
	/**
	 * 
	 */
	private Integer dialogueType;
	/**
	 * 标题
	 */
	private String askTitle;
	/**
	 * 弃用
	 */
	private Integer isDraft;
	/**
	 * 
	 */
	private Integer collectNumber;

}
