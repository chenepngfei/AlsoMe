package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户马甲表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
@Data
@TableName("vest_manage")
public class VestManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long vestId;
	/**
	 * 1:唐小僧 2:孙小悟 3:九戒 4:沙小僧
	 */
	private Integer vestType;
	/**
	 * 
	 */
	private String vestPic;
	/**
	 * 
	 */
	private Date createTime;

}
