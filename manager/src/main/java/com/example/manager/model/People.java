package com.example.manager.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author yuanjie
 * @date 2018/9/27 14:53
 */
@Data
@Component
@ConfigurationProperties(prefix = "people")
//@PropertySource("classpath: people.properties")
public class People {

    private Long id;
    private String name;
    private String password;
}
