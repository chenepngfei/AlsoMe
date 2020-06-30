package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.HelperChargeRuleDao;
import com.am.xinlishejiao.modules.sys.entity.HelperChargeRuleEntity;
import com.am.xinlishejiao.modules.sys.service.HelperChargeRuleService;


@Service("helperChargeRuleService")
public class HelperChargeRuleServiceImpl extends ServiceImpl<HelperChargeRuleDao, HelperChargeRuleEntity> implements HelperChargeRuleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HelperChargeRuleEntity> page = this.page(
                new Query<HelperChargeRuleEntity>().getPage(params),
                new QueryWrapper<HelperChargeRuleEntity>()
        );

        return new PageUtils(page);
    }

}
