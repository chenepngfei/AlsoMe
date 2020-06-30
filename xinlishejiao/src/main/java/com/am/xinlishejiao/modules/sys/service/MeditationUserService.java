package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.MeditationUserEntity;

import java.util.Map;

/**
 * 用户冥想记录表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:57
 */
public interface MeditationUserService extends IService<MeditationUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

