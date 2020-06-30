package com.am.xinlishejiao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Query;

import com.am.xinlishejiao.modules.sys.dao.ReceiptPriceDao;
import com.am.xinlishejiao.modules.sys.entity.ReceiptPriceEntity;
import com.am.xinlishejiao.modules.sys.service.ReceiptPriceService;


@Service("receiptPriceService")
public class ReceiptPriceServiceImpl extends ServiceImpl<ReceiptPriceDao, ReceiptPriceEntity> implements ReceiptPriceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReceiptPriceEntity> page = this.page(
                new Query<ReceiptPriceEntity>().getPage(params),
                new QueryWrapper<ReceiptPriceEntity>()
        );

        return new PageUtils(page);
    }

}
