package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.CommunityUserEntity;

import java.util.Map;

/**
 * 社区用户表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
public interface CommunityUserService extends IService<CommunityUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

