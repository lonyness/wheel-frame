package com.frame.wheel.wheelcore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.frame")
@MapperScan("com.frame.wheel.wheelsystem.dao")
public class WheelCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(WheelCoreApplication.class, args);
    }

}
