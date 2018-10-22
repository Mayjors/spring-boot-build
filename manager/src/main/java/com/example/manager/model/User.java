package com.example.manager.model;

import lombok.Data;

import javax.persistence.Table;

@Table(name = "t_user")
@Data
public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String phone;

}