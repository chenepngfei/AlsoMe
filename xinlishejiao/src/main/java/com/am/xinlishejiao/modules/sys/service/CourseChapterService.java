package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.CourseChapterEntity;

import java.util.Map;

/**
 * 课程章节表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
public interface CourseChapterService extends IService<CourseChapterEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

