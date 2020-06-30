package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.SeekHelpTypeEntity;

import java.util.Map;

/**
 * 求助类型管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface SeekHelpTypeService extends IService<SeekHelpTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

