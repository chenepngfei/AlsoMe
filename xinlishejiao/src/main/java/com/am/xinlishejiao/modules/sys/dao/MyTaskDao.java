package com.am.xinlishejiao.modules.sys.dao;

import com.am.xinlishejiao.modules.sys.entity.MyTaskEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户任务表
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Mapper
public interface MyTaskDao extends BaseMapper<MyTaskEntity> {
	
}
