package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.UserSubsidyEntity;

import java.util.Map;

/**
 * 用户津贴设置表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
public interface UserSubsidyService extends IService<UserSubsidyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

