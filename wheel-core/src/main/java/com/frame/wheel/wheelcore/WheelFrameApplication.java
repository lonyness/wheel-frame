package com.frame.wheel.wheelcore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.frame")
@MapperScan("com.frame.wheel.wheelsystem.dao")
public class WheelFrameApplication {

    public static void main(String[] args) {
        SpringApplication.run(WheelFrameApplication.class, args);
    }

}
