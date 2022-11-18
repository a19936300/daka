package com.binbinxiu.daka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.binbinxiu.daka.mapper"})
@ComponentScan(basePackages = {"com.binbinxiu","org.n3r.idworker"})
public class DakaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DakaApplication.class, args);
    }

}
