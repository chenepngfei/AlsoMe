package com.alsome.alsome_create_model.modules.job.controller;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;
import com.alsome.alsome_create_model.modules.job.entity.ScheduleJobLogEntity;
import com.alsome.alsome_create_model.modules.job.service.ScheduleJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 定时任务日志
 */
@RestController
@RequestMapping("/sys/scheduleLog")
public class ScheduleJobLogController {
	@Autowired
	private ScheduleJobLogService scheduleJobLogService;

	/**
	 * 定时任务日志列表
	 */
	@RequestMapping("/list")
	public Resultful list(@RequestParam Map<String, Object> params){
		PageUtils page = scheduleJobLogService.queryPage(params);

		return Resultful.ok().put("page", page);
	}

	/**
	 * 定时任务日志信息
	 */
	@RequestMapping("/info/{logId}")
	public Resultful info(@PathVariable("logId") Long logId){
		ScheduleJobLogEntity log = scheduleJobLogService.getById(logId);

		return Resultful.ok().put("log", log);
	}
}
