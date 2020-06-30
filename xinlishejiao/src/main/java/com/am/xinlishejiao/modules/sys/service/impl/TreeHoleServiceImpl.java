package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.TreeHoleDao;
import com.am.xinlishejiao.modules.sys.entity.TreeHoleEntity;
import com.am.xinlishejiao.modules.sys.service.TreeHoleService;


@Service("treeHoleService")
public class TreeHoleServiceImpl extends ServiceImpl<TreeHoleDao, TreeHoleEntity> implements TreeHoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TreeHoleEntity> page = this.page(
                new Query<TreeHoleEntity>().getPage(params),
                new QueryWrapper<TreeHoleEntity>()
        );

        return new PageUtils(page);
    }

}
