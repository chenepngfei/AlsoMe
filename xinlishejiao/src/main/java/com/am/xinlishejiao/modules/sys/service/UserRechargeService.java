package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.UserRechargeEntity;

import java.util.Map;

/**
 * 用户充值记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
public interface UserRechargeService extends IService<UserRechargeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

