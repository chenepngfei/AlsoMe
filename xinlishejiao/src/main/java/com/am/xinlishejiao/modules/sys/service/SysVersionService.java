package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.SysVersionEntity;

import java.util.Map;

/**
 * 系统版本管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface SysVersionService extends IService<SysVersionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

