package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.HelperChargeRuleEntity;

import java.util.Map;

/**
 * helper收费规则表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
public interface HelperChargeRuleService extends IService<HelperChargeRuleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

