package com.example.rabbitdemo.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author disfang
 */
@Table(name = "model")
@Data
public class Model implements Serializable {

    @Id
    private Integer id;

    private String name;

    private String password;

}