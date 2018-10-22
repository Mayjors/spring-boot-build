package com.example.pojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PojoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PojoApplication.class, args);
    }
}
