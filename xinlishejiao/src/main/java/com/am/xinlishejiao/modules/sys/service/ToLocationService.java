package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.ToLocationEntity;

import java.util.Map;

/**
 * 全球地区库，采集自腾讯QQ国内+国际版.ADD.JENA.20141221
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface ToLocationService extends IService<ToLocationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

