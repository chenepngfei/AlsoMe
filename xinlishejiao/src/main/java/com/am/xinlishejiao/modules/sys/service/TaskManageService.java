package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.TaskManageEntity;

import java.util.Map;

/**
 * 任务管理表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface TaskManageService extends IService<TaskManageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

