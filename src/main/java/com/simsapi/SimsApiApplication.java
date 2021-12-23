package com.simsapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Service;

@MapperScan("com.simsapi.mapper")
@SpringBootApplication
public class SimsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimsApiApplication.class, args);
    }

}
