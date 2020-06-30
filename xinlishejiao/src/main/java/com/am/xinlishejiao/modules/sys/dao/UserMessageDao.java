package com.am.xinlishejiao.modules.sys.dao;

import com.am.xinlishejiao.modules.sys.entity.UserMessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户消息表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
@Mapper
public interface UserMessageDao extends BaseMapper<UserMessageEntity> {
	
}
