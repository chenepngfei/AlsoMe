package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.TaskManageDao;
import com.am.xinlishejiao.modules.sys.entity.TaskManageEntity;
import com.am.xinlishejiao.modules.sys.service.TaskManageService;


@Service("taskManageService")
public class TaskManageServiceImpl extends ServiceImpl<TaskManageDao, TaskManageEntity> implements TaskManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TaskManageEntity> page = this.page(
                new Query<TaskManageEntity>().getPage(params),
                new QueryWrapper<TaskManageEntity>()
        );

        return new PageUtils(page);
    }

}
