package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.SysKeyWordEntity;

import java.util.Map;

/**
 * 关键词搜索表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface SysKeyWordService extends IService<SysKeyWordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

