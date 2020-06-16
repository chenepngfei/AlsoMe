package com.alsome.alsome_create_model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class AlsomeCreateModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlsomeCreateModelApplication.class, args);
    }

}
