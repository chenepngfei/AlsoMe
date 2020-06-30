package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.RepleaseLikeEntity;

import java.util.Map;

/**
 * 站内点赞,收藏表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:56
 */
public interface RepleaseLikeService extends IService<RepleaseLikeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

