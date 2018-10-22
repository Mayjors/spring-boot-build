package com.example.rpclearning.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author yuanjie
 * @date 2018/9/26 9:52
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    private Long id;

    private String userName;

    private Integer age;

    public User(Long id, String userName, Integer age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }
}
