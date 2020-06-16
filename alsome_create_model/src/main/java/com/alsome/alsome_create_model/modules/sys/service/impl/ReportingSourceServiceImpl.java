package com.alsome.alsome_create_model.modules.sys.service.impl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;
import com.alsome.alsome_create_model.modules.sys.dao.ReportingSourceDao;
import com.alsome.alsome_create_model.modules.sys.entity.ReportingSource;
import com.alsome.alsome_create_model.modules.sys.service.ReportingSourceService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("reportingSourceService")
public class ReportingSourceServiceImpl extends ServiceImpl<ReportingSourceDao, ReportingSource> implements ReportingSourceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReportingSource> page = this.page(
                new Query<ReportingSource>().getPage(params),
                new QueryWrapper<ReportingSource>()
        );

        return new PageUtils(page);
    }

}
