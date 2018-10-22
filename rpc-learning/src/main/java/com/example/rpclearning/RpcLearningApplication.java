package com.example.rpclearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RpcLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpcLearningApplication.class, args);
    }
}
