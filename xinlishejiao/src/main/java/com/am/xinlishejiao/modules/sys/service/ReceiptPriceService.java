package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.ReceiptPriceEntity;

import java.util.Map;

/**
 * �ӵ����ù����
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface ReceiptPriceService extends IService<ReceiptPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

