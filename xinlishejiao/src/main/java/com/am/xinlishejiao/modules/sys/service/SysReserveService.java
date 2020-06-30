package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.SysReserveEntity;

import java.util.Map;

/**
 * 用户预约专家记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface SysReserveService extends IService<SysReserveEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

