package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.CourseCategoryEntity;

import java.util.Map;

/**
 * 课程类别表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
public interface CourseCategoryService extends IService<CourseCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

