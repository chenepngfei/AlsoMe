package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.MyTaskDao;
import com.am.xinlishejiao.modules.sys.entity.MyTaskEntity;
import com.am.xinlishejiao.modules.sys.service.MyTaskService;


@Service("myTaskService")
public class MyTaskServiceImpl extends ServiceImpl<MyTaskDao, MyTaskEntity> implements MyTaskService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MyTaskEntity> page = this.page(
                new Query<MyTaskEntity>().getPage(params),
                new QueryWrapper<MyTaskEntity>()
        );

        return new PageUtils(page);
    }

}
