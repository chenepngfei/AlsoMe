package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.RepleaseCommentEntity;

import java.util.Map;

/**
 * 提问/想法/树洞 /最新资讯评论表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface RepleaseCommentService extends IService<RepleaseCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

