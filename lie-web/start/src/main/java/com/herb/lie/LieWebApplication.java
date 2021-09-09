package com.herb.lie;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value = {"com.herb.lie.dao.mapper.book"})
public class LieWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LieWebApplication.class, args);
    }

}
