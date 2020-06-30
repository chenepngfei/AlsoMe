package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.VestManageEntity;

import java.util.Map;

/**
 * 用户马甲表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
public interface VestManageService extends IService<VestManageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

