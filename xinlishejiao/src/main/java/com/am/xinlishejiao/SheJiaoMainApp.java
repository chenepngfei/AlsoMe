package com.am.xinlishejiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class SheJiaoMainApp {
    public static void main(String[] args) {
        SpringApplication.run(SheJiaoMainApp.class, args);
    }
}
