package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.UserExaminationResultsEntity;

import java.util.Map;

/**
 * 用户课程考试结果表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
public interface UserExaminationResultsService extends IService<UserExaminationResultsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

