package com.binbinxiu.daka.schedu;

import cn.hutool.core.io.file.FileWriter;
import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Map;

@Configuration
@EnableScheduling
public class DataScheduleTask {

//
//    @Scheduled(cron = "0/5 * * * * ?")
//    private void renWuTask(){
//        System.out.println("开始执行同步renwu任务: "+ LocalDateTime.now());
//        Map<String, Ob> renWuMap = RenWuDao.getRenWuMap();
//        String renWuJson = JSON.toJSONString(renWuMap);
//
//        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"data/renwu.json";
//        FileWriter fileWriter = new FileWriter(path);
//        fileWriter.write(renWuJson);
//    }
}
