package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.SysMessageDao;
import com.am.xinlishejiao.modules.sys.entity.SysMessageEntity;
import com.am.xinlishejiao.modules.sys.service.SysMessageService;


@Service("sysMessageService")
public class SysMessageServiceImpl extends ServiceImpl<SysMessageDao, SysMessageEntity> implements SysMessageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysMessageEntity> page = this.page(
                new Query<SysMessageEntity>().getPage(params),
                new QueryWrapper<SysMessageEntity>()
        );

        return new PageUtils(page);
    }

}
