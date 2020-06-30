package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.DialogueDao;
import com.am.xinlishejiao.modules.sys.entity.DialogueEntity;
import com.am.xinlishejiao.modules.sys.service.DialogueService;


@Service("dialogueService")
public class DialogueServiceImpl extends ServiceImpl<DialogueDao, DialogueEntity> implements DialogueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DialogueEntity> page = this.page(
                new Query<DialogueEntity>().getPage(params),
                new QueryWrapper<DialogueEntity>()
        );

        return new PageUtils(page);
    }

}
