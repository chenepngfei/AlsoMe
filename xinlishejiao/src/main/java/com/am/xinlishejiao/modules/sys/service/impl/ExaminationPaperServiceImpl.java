package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.ExaminationPaperDao;
import com.am.xinlishejiao.modules.sys.entity.ExaminationPaperEntity;
import com.am.xinlishejiao.modules.sys.service.ExaminationPaperService;


@Service("examinationPaperService")
public class ExaminationPaperServiceImpl extends ServiceImpl<ExaminationPaperDao, ExaminationPaperEntity> implements ExaminationPaperService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExaminationPaperEntity> page = this.page(
                new Query<ExaminationPaperEntity>().getPage(params),
                new QueryWrapper<ExaminationPaperEntity>()
        );

        return new PageUtils(page);
    }

}
