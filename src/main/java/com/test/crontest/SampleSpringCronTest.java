package com.test.crontest;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

public class SampleSpringCronTest {

	@Scheduled(cron="*/5 * * * * ?") //for every 5 seconds triggered this method
	//@Scheduled(cron = "0 15 10 * * ? 2019") //Fires at 10:15 AM every day in the year 2019:
	//@Scheduled(cron="0 8 11 * * ?") //Fires at 11:08 AM every day
	public void testCronSchedular(){
		System.out.println("Method executed at every 5 seconds :: " + new Date());
	}
}

/*https://howtodoinjava.com/spring-core/4-ways-to-schedule-tasks-in-spring-3-scheduled-example/*/