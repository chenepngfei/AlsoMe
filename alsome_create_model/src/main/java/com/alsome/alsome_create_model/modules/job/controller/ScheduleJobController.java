package com.alsome.alsome_create_model.modules.job.controller;
import com.AlsoMe.commons.utils.PageUtils;
import com.AlsoMe.commons.utils.Resultful;
import com.AlsoMe.commons.utils.ValidatorUtils;
import com.alsome.alsome_create_model.common.annotation.SysLog;
import com.alsome.alsome_create_model.modules.job.entity.ScheduleJobEntity;
import com.alsome.alsome_create_model.modules.job.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 定时任务
 */
@RestController
@RequestMapping("/sys/schedule")
public class ScheduleJobController {
	@Autowired
	private ScheduleJobService scheduleJobService;

	/**
	 * 定时任务列表
	 */
	@RequestMapping("/list")
	public Resultful list(@RequestParam Map<String, Object> params){
		PageUtils page = scheduleJobService.queryPage(params);

		return Resultful.ok().put("page", page);
	}

	/**
	 * 定时任务信息
	 */
	@RequestMapping("/info/{jobId}")
	public Resultful info(@PathVariable("jobId") Long jobId){
		ScheduleJobEntity schedule = scheduleJobService.getById(jobId);

		return Resultful.ok().put("schedule", schedule);
	}

	/**
	 * 保存定时任务
	 */
	@SysLog("保存定时任务")
	@RequestMapping("/save")
	public Resultful save(@RequestBody ScheduleJobEntity scheduleJob){
		ValidatorUtils.validateEntity(scheduleJob);

		scheduleJobService.saveJob(scheduleJob);

		return Resultful.ok();
	}

	/**
	 * 修改定时任务
	 */
	@SysLog("修改定时任务")
	@RequestMapping("/update")
	public Resultful update(@RequestBody ScheduleJobEntity scheduleJob){
		ValidatorUtils.validateEntity(scheduleJob);

		scheduleJobService.update(scheduleJob);

		return Resultful.ok();
	}

	/**
	 * 删除定时任务
	 */
	@SysLog("删除定时任务")
	@RequestMapping("/delete")
	public Resultful delete(@RequestBody Long[] jobIds){
		scheduleJobService.deleteBatch(jobIds);

		return Resultful.ok();
	}

	/**
	 * 立即执行任务
	 */
	@SysLog("立即执行任务")
	@RequestMapping("/run")
	public Resultful run(@RequestBody Long[] jobIds){
		scheduleJobService.run(jobIds);

		return Resultful.ok();
	}

	/**
	 * 暂停定时任务
	 */
	@SysLog("暂停定时任务")
	@RequestMapping("/pause")
	public Resultful pause(@RequestBody Long[] jobIds){
		scheduleJobService.pause(jobIds);

		return Resultful.ok();
	}

	/**
	 * 恢复定时任务
	 */
	@SysLog("恢复定时任务")
	@RequestMapping("/resume")
	public Resultful resume(@RequestBody Long[] jobIds){
		scheduleJobService.resume(jobIds);

		return Resultful.ok();
	}

}
