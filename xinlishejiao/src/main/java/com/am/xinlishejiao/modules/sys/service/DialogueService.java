package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.DialogueEntity;

import java.util.Map;

/**
 * 提问/想法通用表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
public interface DialogueService extends IService<DialogueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

