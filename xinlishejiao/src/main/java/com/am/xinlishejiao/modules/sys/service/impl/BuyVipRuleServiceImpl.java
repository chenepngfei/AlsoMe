package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.BuyVipRuleDao;
import com.am.xinlishejiao.modules.sys.entity.BuyVipRuleEntity;
import com.am.xinlishejiao.modules.sys.service.BuyVipRuleService;


@Service("buyVipRuleService")
public class BuyVipRuleServiceImpl extends ServiceImpl<BuyVipRuleDao, BuyVipRuleEntity> implements BuyVipRuleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BuyVipRuleEntity> page = this.page(
                new Query<BuyVipRuleEntity>().getPage(params),
                new QueryWrapper<BuyVipRuleEntity>()
        );

        return new PageUtils(page);
    }

}
