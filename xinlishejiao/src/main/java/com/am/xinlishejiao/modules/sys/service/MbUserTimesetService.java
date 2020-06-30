package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.MbUserTimesetEntity;

import java.util.Map;

/**
 * helper预约时间设置
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface MbUserTimesetService extends IService<MbUserTimesetEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

