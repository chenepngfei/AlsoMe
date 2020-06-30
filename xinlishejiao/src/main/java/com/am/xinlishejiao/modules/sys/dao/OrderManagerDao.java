package com.am.xinlishejiao.modules.sys.dao;

import com.am.xinlishejiao.modules.sys.entity.OrderManagerEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 购买会员订单记录表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Mapper
public interface OrderManagerDao extends BaseMapper<OrderManagerEntity> {
	
}
