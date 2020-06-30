package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
@Data
@TableName("advert_manage")
public class AdvertManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long advertId;
	/**
	 * 
	 */
	private String advertName;
	/**
	 * 
	 */
	private String advertPic;
	/**
	 * 
	 */
	private String advertUrl;
	/**
	 * 0:在线   1:下线
	 */
	private Integer state;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 0:广告页 4:最新资讯 5:发现首页顶部 6:社区广告 7:课程页面 8:发现首页底部
	 */
	private Integer advertType;
	/**
	 * 跳转目标ID
	 */
	private Long targetId;
	/**
	 * 0:自定义广告 1:图文资讯 2:课程 3:测试题 4:卡牌测试 5:视频资讯
	 */
	private Integer targetType;

}
