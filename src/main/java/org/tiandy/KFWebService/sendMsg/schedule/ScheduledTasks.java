package org.tiandy.KFWebService.sendMsg.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.tiandy.KFWebService.sendMsg.config.B2BConfig;
import org.tiandy.KFWebService.sendMsg.dao.SendMsgDao;
import org.tiandy.KFWebService.sendMsg.entity.msg.TbUser;

@Component
@Configurable
@EnableScheduling
@PropertySource("classpath:/config.properties")
public class ScheduledTasks{
	@Resource
	SendMsgDao dao;
	
    @Scheduled(fixedRateString =  "${fixedRate}")
    public void reportCurrentTime(){
    	Map<String,Object> map = new HashMap<String,Object>();
    	List<TbUser> findAll = dao.findAll(map);
    	for(TbUser user :findAll){
    		System.out.println(user.getId()+" ||| " + user.getPassword() +" ||| "+user.getUsername());
    	}
        System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date ()));
    }

    //每1分钟执行一次
    @Scheduled(cron = "${cron}")
    public void reportCurrentByCron(){
        System.out.println ("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date ()));
    }

    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("HH:mm:ss");
    }
    
}