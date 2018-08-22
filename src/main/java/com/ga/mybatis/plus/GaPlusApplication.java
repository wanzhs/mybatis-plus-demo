package com.ga.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ga.mybatis.plus.mapper")
public class GaPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(GaPlusApplication.class, args);
    }
}
