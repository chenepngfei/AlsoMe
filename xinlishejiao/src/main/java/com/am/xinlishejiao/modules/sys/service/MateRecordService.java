package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.MateRecordEntity;

import java.util.Map;

/**
 * 匹配记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface MateRecordService extends IService<MateRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

