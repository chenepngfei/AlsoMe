package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.OrderManagerEntity;

import java.util.Map;

/**
 * 购买会员订单记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface OrderManagerService extends IService<OrderManagerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

