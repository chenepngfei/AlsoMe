package com.am.xinlishejiao.modules.sys.dao;

import com.am.xinlishejiao.modules.sys.entity.UserWithdrawalEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户提现记录表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
@Mapper
public interface UserWithdrawalDao extends BaseMapper<UserWithdrawalEntity> {
	
}
