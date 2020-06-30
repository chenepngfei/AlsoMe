package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.SeekHelpHistoryDao;
import com.am.xinlishejiao.modules.sys.entity.SeekHelpHistoryEntity;
import com.am.xinlishejiao.modules.sys.service.SeekHelpHistoryService;


@Service("seekHelpHistoryService")
public class SeekHelpHistoryServiceImpl extends ServiceImpl<SeekHelpHistoryDao, SeekHelpHistoryEntity> implements SeekHelpHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SeekHelpHistoryEntity> page = this.page(
                new Query<SeekHelpHistoryEntity>().getPage(params),
                new QueryWrapper<SeekHelpHistoryEntity>()
        );

        return new PageUtils(page);
    }

}
