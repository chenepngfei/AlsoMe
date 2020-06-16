package com.alsome.alsome_create_model.modules.sys.service;
import com.AlsoMe.commons.utils.PageUtils;
import com.alsome.alsome_create_model.modules.sys.entity.SysLogEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Map;


/**
 * 系统日志
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
