package com.btlab.fdcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients(basePackages = "com.btlab.fdcalculator.client")
public class FdCalculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(FdCalculatorApplication.class, args);
    }
}
