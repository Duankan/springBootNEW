package com.example.demo.task;

import com.example.demo.entity.Work;
import com.example.demo.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling // 启用定时任务
public class SchedulingConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    WorkService workService;
    @Scheduled(cron = "0/20 * * * * ?") // 每20秒执行一次
    public void scheduler() {
        Work work=workService.getWorkById(1);
        logger.info(">>> "+work.toString());
    }
}
