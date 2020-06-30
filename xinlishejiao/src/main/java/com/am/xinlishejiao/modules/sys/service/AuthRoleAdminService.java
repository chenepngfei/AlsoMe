package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.AuthRoleAdminEntity;

import java.util.Map;

/**
 * 管理员角色表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
public interface AuthRoleAdminService extends IService<AuthRoleAdminEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

