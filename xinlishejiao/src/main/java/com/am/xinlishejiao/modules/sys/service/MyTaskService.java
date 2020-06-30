package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.MyTaskEntity;

import java.util.Map;

/**
 * 用户任务表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface MyTaskService extends IService<MyTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

