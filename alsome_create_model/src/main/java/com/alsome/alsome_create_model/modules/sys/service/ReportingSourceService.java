package com.alsome.alsome_create_model.modules.sys.service;
import com.AlsoMe.commons.utils.PageUtils;
import com.alsome.alsome_create_model.modules.sys.entity.ReportingSource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 报告来源
 *
 * @author cpf
 * @email chenpfmail@163.com
 * @date 2020-06-08 15:24:09
 */
public interface ReportingSourceService extends IService<ReportingSource> {

    PageUtils queryPage(Map<String, Object> params);
}

