package com.example.rabbitdemo.model;

import lombok.Data;
import javax.persistence.Id;

/**
 * @author yuanjie
 * @date 2018/11/24 10:34
 */
@Data
public class People {

    @Id
    private Integer id;
    private String name;
    private Integer age;
    private String detail;
}
