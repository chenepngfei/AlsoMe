package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.AuthAdminEntity;

import java.util.Map;

/**
 * 后台管理员表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
public interface AuthAdminService extends IService<AuthAdminEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

