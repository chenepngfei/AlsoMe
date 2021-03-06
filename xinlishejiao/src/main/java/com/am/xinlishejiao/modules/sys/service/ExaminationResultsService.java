package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.ExaminationResultsEntity;

import java.util.Map;

/**
 * 试题结果表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
public interface ExaminationResultsService extends IService<ExaminationResultsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

