package com.alsome.alsome_create_model.modules.sys.service;
import com.AlsoMe.commons.utils.PageUtils;
import com.alsome.alsome_create_model.modules.sys.entity.ReportingUnit;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Map;

/**
 * 报告单位
 *
 * @author cpf
 * @email chenpfmail@163.com
 * @date 2020-06-08 15:24:09
 */
public interface ReportingUnitService extends IService<ReportingUnit> {

    PageUtils queryPage(Map<String, Object> params);
}

