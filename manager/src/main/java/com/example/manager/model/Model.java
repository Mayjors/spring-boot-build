package com.example.manager.model;

import lombok.Data;

import javax.persistence.Table;

@Table(name = "model")
@Data
public class Model {

    private Integer id;

    private String name;

    private String password;

}