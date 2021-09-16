package com.herb.lie;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//@SpringBootApplication：标注这个类是一个springboot的应用
@SpringBootApplication
@MapperScan(value = {"com.herb.lie.dao.mapper"})
public class LieWebApplication {
    public static void main(String[] args) {
        //将springboot应用启动
        SpringApplication.run(LieWebApplication.class, args);
    }
}
