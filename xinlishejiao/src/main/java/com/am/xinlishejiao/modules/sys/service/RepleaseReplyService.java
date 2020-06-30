package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.RepleaseReplyEntity;

import java.util.Map;

/**
 * 站内评论回复表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface RepleaseReplyService extends IService<RepleaseReplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

