package com.alsome.alsome_create_model.modules.sys.service.impl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;
import com.alsome.alsome_create_model.modules.sys.dao.ReportingUnitDao;
import com.alsome.alsome_create_model.modules.sys.entity.ReportingUnit;
import com.alsome.alsome_create_model.modules.sys.service.ReportingUnitService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service("reportingUnitService")
public class ReportingUnitServiceImpl extends ServiceImpl<ReportingUnitDao, ReportingUnit> implements ReportingUnitService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReportingUnit> page = this.page(
                new Query<ReportingUnit>().getPage(params),
                new QueryWrapper<ReportingUnit>()
        );

        return new PageUtils(page);
    }

}
