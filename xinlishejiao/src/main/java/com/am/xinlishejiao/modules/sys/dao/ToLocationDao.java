package com.am.xinlishejiao.modules.sys.dao;

import com.am.xinlishejiao.modules.sys.entity.ToLocationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 全球地区库，采集自腾讯QQ国内+国际版.ADD.JENA.20141221
 * 
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
@Mapper
public interface ToLocationDao extends BaseMapper<ToLocationEntity> {
	
}
