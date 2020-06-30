package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.SysKeyWordDao;
import com.am.xinlishejiao.modules.sys.entity.SysKeyWordEntity;
import com.am.xinlishejiao.modules.sys.service.SysKeyWordService;


@Service("sysKeyWordService")
public class SysKeyWordServiceImpl extends ServiceImpl<SysKeyWordDao, SysKeyWordEntity> implements SysKeyWordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysKeyWordEntity> page = this.page(
                new Query<SysKeyWordEntity>().getPage(params),
                new QueryWrapper<SysKeyWordEntity>()
        );

        return new PageUtils(page);
    }

}
