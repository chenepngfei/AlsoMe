package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.ExaminationQuestionsEntity;

import java.util.Map;

/**
 * 试题管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
public interface ExaminationQuestionsService extends IService<ExaminationQuestionsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

