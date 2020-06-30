package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.QuizzesCardTypeDao;
import com.am.xinlishejiao.modules.sys.entity.QuizzesCardTypeEntity;
import com.am.xinlishejiao.modules.sys.service.QuizzesCardTypeService;


@Service("quizzesCardTypeService")
public class QuizzesCardTypeServiceImpl extends ServiceImpl<QuizzesCardTypeDao, QuizzesCardTypeEntity> implements QuizzesCardTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QuizzesCardTypeEntity> page = this.page(
                new Query<QuizzesCardTypeEntity>().getPage(params),
                new QueryWrapper<QuizzesCardTypeEntity>()
        );

        return new PageUtils(page);
    }

}
