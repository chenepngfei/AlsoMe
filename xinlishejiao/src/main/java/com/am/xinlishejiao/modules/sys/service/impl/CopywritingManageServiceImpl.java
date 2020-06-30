package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.CopywritingManageDao;
import com.am.xinlishejiao.modules.sys.entity.CopywritingManageEntity;
import com.am.xinlishejiao.modules.sys.service.CopywritingManageService;


@Service("copywritingManageService")
public class CopywritingManageServiceImpl extends ServiceImpl<CopywritingManageDao, CopywritingManageEntity> implements CopywritingManageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CopywritingManageEntity> page = this.page(
                new Query<CopywritingManageEntity>().getPage(params),
                new QueryWrapper<CopywritingManageEntity>()
        );

        return new PageUtils(page);
    }

}
