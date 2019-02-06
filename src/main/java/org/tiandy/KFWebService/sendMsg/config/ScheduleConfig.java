package org.tiandy.KFWebService.sendMsg.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tiandy.KFWebService.sendMsg.schedule.ScheduleManger;
import org.tiandy.KFWebService.sendMsg.schedule.ScheduleRunner;

@Configuration
public class ScheduleConfig {
	@Resource
	ScheduleRunner runer;
	
	@Bean
	public ScheduleManger scheduleManger(){
		runer.run();
		ScheduleManger manager = new ScheduleManger();
		return manager;
	}
	
}
