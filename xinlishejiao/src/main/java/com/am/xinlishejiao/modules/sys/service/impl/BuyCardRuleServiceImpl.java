package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.BuyCardRuleDao;
import com.am.xinlishejiao.modules.sys.entity.BuyCardRuleEntity;
import com.am.xinlishejiao.modules.sys.service.BuyCardRuleService;


@Service("buyCardRuleService")
public class BuyCardRuleServiceImpl extends ServiceImpl<BuyCardRuleDao, BuyCardRuleEntity> implements BuyCardRuleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BuyCardRuleEntity> page = this.page(
                new Query<BuyCardRuleEntity>().getPage(params),
                new QueryWrapper<BuyCardRuleEntity>()
        );

        return new PageUtils(page);
    }

}
