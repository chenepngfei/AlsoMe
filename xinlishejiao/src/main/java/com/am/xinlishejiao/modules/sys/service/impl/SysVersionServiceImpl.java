package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.SysVersionDao;
import com.am.xinlishejiao.modules.sys.entity.SysVersionEntity;
import com.am.xinlishejiao.modules.sys.service.SysVersionService;


@Service("sysVersionService")
public class SysVersionServiceImpl extends ServiceImpl<SysVersionDao, SysVersionEntity> implements SysVersionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysVersionEntity> page = this.page(
                new Query<SysVersionEntity>().getPage(params),
                new QueryWrapper<SysVersionEntity>()
        );

        return new PageUtils(page);
    }

}
