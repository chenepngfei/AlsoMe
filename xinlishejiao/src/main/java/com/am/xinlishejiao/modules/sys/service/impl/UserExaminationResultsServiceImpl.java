package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.UserExaminationResultsDao;
import com.am.xinlishejiao.modules.sys.entity.UserExaminationResultsEntity;
import com.am.xinlishejiao.modules.sys.service.UserExaminationResultsService;


@Service("userExaminationResultsService")
public class UserExaminationResultsServiceImpl extends ServiceImpl<UserExaminationResultsDao, UserExaminationResultsEntity> implements UserExaminationResultsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserExaminationResultsEntity> page = this.page(
                new Query<UserExaminationResultsEntity>().getPage(params),
                new QueryWrapper<UserExaminationResultsEntity>()
        );

        return new PageUtils(page);
    }

}
