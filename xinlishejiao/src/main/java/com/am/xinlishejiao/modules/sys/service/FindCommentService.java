package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.FindCommentEntity;

import java.util.Map;

/**
 * 课程/广播/视频评论表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
public interface FindCommentService extends IService<FindCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

