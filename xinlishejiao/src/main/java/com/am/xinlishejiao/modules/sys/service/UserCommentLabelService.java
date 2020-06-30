package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.UserCommentLabelEntity;

import java.util.Map;

/**
 * 用户评论标签表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface UserCommentLabelService extends IService<UserCommentLabelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

