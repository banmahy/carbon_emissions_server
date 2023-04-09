package com.example.ceserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ceserver.mapper")
public class CarbonEmissionsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarbonEmissionsServerApplication.class, args);
    }

}
