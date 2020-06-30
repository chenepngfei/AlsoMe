package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.UserWithdrawalEntity;

import java.util.Map;

/**
 * 用户提现记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
public interface UserWithdrawalService extends IService<UserWithdrawalEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

