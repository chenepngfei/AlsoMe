package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.SysSeekHelpDao;
import com.am.xinlishejiao.modules.sys.entity.SysSeekHelpEntity;
import com.am.xinlishejiao.modules.sys.service.SysSeekHelpService;


@Service("sysSeekHelpService")
public class SysSeekHelpServiceImpl extends ServiceImpl<SysSeekHelpDao, SysSeekHelpEntity> implements SysSeekHelpService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysSeekHelpEntity> page = this.page(
                new Query<SysSeekHelpEntity>().getPage(params),
                new QueryWrapper<SysSeekHelpEntity>()
        );

        return new PageUtils(page);
    }

}
