package com.am.xinlishejiao.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * �ӵ����ù����
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Data
@TableName("receipt_price")
public class ReceiptPriceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long receiptPriceId;
	/**
	 * 0:ר��   1:helper
	 */
	private Integer receiptType;
	/**
	 * 
	 */
	private Double lowestPrice;
	/**
	 * 
	 */
	private Double highestPrice;
	/**
	 * 
	 */
	private Date createTime;

}
