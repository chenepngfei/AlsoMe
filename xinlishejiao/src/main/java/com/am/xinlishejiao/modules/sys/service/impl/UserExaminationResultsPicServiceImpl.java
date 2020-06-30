package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.UserExaminationResultsPicDao;
import com.am.xinlishejiao.modules.sys.entity.UserExaminationResultsPicEntity;
import com.am.xinlishejiao.modules.sys.service.UserExaminationResultsPicService;


@Service("userExaminationResultsPicService")
public class UserExaminationResultsPicServiceImpl extends ServiceImpl<UserExaminationResultsPicDao, UserExaminationResultsPicEntity> implements UserExaminationResultsPicService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserExaminationResultsPicEntity> page = this.page(
                new Query<UserExaminationResultsPicEntity>().getPage(params),
                new QueryWrapper<UserExaminationResultsPicEntity>()
        );

        return new PageUtils(page);
    }

}
