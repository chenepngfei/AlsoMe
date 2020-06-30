package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.TestStatisticsEntity;

import java.util.Map;

/**
 * 测试题统计管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface TestStatisticsService extends IService<TestStatisticsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

