package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.UserExaminationResultsPicEntity;

import java.util.Map;

/**
 * 用户课程考试结果图片表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
public interface UserExaminationResultsPicService extends IService<UserExaminationResultsPicEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

