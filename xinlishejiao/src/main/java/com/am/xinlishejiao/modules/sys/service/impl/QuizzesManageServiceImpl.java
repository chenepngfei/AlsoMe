package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.QuizzesManageDao;
import com.am.xinlishejiao.modules.sys.entity.QuizzesManageEntity;
import com.am.xinlishejiao.modules.sys.service.QuizzesManageService;


@Service("quizzesManageService")
public class QuizzesManageServiceImpl extends ServiceImpl<QuizzesManageDao, QuizzesManageEntity> implements QuizzesManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QuizzesManageEntity> page = this.page(
                new Query<QuizzesManageEntity>().getPage(params),
                new QueryWrapper<QuizzesManageEntity>()
        );

        return new PageUtils(page);
    }

}
