package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.BuyCardRuleEntity;

import java.util.Map;

/**
 * 每日卡片抽取次数/匹配次数规则表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
public interface BuyCardRuleService extends IService<BuyCardRuleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

