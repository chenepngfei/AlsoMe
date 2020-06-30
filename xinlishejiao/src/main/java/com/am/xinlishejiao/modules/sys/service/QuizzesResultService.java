package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.QuizzesResultEntity;

import java.util.Map;

/**
 * 用户测试结果表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface QuizzesResultService extends IService<QuizzesResultEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

