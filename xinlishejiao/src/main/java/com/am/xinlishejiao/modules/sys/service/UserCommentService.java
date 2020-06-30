package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.UserCommentEntity;

import java.util.Map;

/**
 * 评论用户表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface UserCommentService extends IService<UserCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

