package com.am.xinlishejiao.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.AlsoMe.commons.utils.PageUtils;
import com.am.xinlishejiao.modules.sys.entity.UserCertificatesEntity;

import java.util.Map;

/**
 * 专家证件资质表
 *
 * @author cpf
 * @email ${email}
 * @date 2020-06-30 10:58:55
 */
public interface UserCertificatesService extends IService<UserCertificatesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

