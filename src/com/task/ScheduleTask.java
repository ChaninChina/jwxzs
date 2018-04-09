package com.task;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.service.IStrwService;
import com.service.IXxxxService;
import com.service.IYhRwService;
import com.service.Impl.XxxxService;
import com.util.DateUtil;

@Component
public class ScheduleTask {
	Logger logger = Logger.getLogger(ScheduleTask.class);
	
	@Resource
	IYhRwService yhRwService;
	@Resource
	IStrwService strwService;
	@Resource
	IXxxxService xxxxService;
	
	
	
	//定时任务测试
	@Scheduled(cron = "0 * * * * ?")
	public void testTask() throws Exception {
		System.out.println("定时任务！启动"+DateUtil.getNowDate());
	}
	
	//每小时运行一次
	@Scheduled(cron = "0 0 * * * ?")
	public void hourTask() throws Exception {
		System.out.println("每小时定时任务运行"+DateUtil.getNowDate());
		logger.info("每小时定时任务运行"+DateUtil.getNowDate());
		yhRwService.updateYhRwWcztByHour();
	}
	
	//每天运行一次
	@Scheduled(cron = "0 0 0 * * ?")
	public void dayTask() throws Exception {
		System.out.println("每天定时任务运行"+DateUtil.getNowDate());
		logger.info("每天定时任务运行"+DateUtil.getNowDate());
		yhRwService.updateYhRwWcztByDay();
	}
	
	
	//每周运行一次
	@Scheduled(cron = "0 0 0 ? * MON")
	public void weekTask() throws Exception {
		System.out.println("每周定时任务运行"+DateUtil.getNowDate());
		logger.info("每周定时任务运行"+DateUtil.getNowDate());
		yhRwService.updateYhRwWcztByWeek();
	}
	
	
	//每月运行一次
	@Scheduled(cron = "0 0 0 1 * ?")
	public void monthTask() throws Exception {
		System.out.println("每月定时任务运行"+DateUtil.getNowDate());
		logger.info("每月定时任务运行"+DateUtil.getNowDate());
		yhRwService.updateYhRwWcztByMonth();
	}
	
	
	//每季度运行一次
	@Scheduled(cron = "0 0 0 1 1,4,7,10 ?")
	public void quarterTask() throws Exception {
		System.out.println("每季度定时任务运行"+DateUtil.getNowDate());
		logger.info("每季度定时任务运行"+DateUtil.getNowDate());
		yhRwService.updateYhRwWcztByQuarter();
	}
	
	//每年运行一次
	@Scheduled(cron = "0 0 0 1 1 *")
	public void yearTask() throws Exception {
		System.out.println("每年定时任务运行"+DateUtil.getNowDate());
		logger.info("每年定时任务运行"+DateUtil.getNowDate());
		yhRwService.updateYhRwWcztByYear();
	}
	
	//每小时50分运行
	@Scheduled(cron = "0 50 * * * ?")
	public void beforHourTask() throws Exception{
		System.out.println("每小时自动生成任务未完成提醒消息"+DateUtil.getNowDate());
		logger.info("每小时自动生成任务未完成提醒消息"+DateUtil.getNowDate());
		xxxxService.insertXxxxByHour();
	}
	
	//每天15时运行
	@Scheduled(cron = "0 0 15 * * ?")
	public void beforDayTask() throws Exception{
		System.out.println("每天自动生成任务未完成提醒消息"+DateUtil.getNowDate());
		logger.info("每天自动生成任务未完成提醒消息"+DateUtil.getNowDate());
		xxxxService.insertXxxxByDay();
	}
	
	//每周星期五16时30分运行
	@Scheduled(cron = "0 30 16 ? * FRI")
	public void beforWeekTask() throws Exception{
		System.out.println("每星期自动生成任务未完成提醒消息"+DateUtil.getNowDate());
		logger.info("每星期自动生成任务未完成提醒消息"+DateUtil.getNowDate());
		xxxxService.insertXxxxByWeek();
	}
	
	//每月25日17时运行
	@Scheduled(cron = "0 0 17 25 * ?")
	public void beforMonthTask() throws Exception{
		System.out.println("每月自动生成任务未完成提醒消息"+DateUtil.getNowDate());
		logger.info("每月自动生成任务未完成提醒消息"+DateUtil.getNowDate());
		xxxxService.insertXxxxByMonth();
	}
	
	//每季度25日16时运行
	@Scheduled(cron = "0 0 16 1 3,6,9,12 ?")
	public void beforQuarterTask() throws Exception{
		System.out.println("每季度自动生成任务未完成提醒消息"+DateUtil.getNowDate());
		logger.info("每季度自动生成任务未完成提醒消息"+DateUtil.getNowDate());
		xxxxService.insertXxxxByQuarter();
	}
	
	//每年12月15日14时运行
	@Scheduled(cron = "0 0 14 15 12 *")
	public void beforYearTask() throws Exception{
		System.out.println("每年自动生成任务未完成提醒消息"+DateUtil.getNowDate());
		logger.info("每年自动生成任务未完成提醒消息"+DateUtil.getNowDate());
		xxxxService.insertXxxxByYear();
	}
	
	
}
