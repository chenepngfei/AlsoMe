package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.RepleasePicsEntity;

import java.util.Map;

/**
 * 想法,树洞图片管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface RepleasePicsService extends IService<RepleasePicsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

