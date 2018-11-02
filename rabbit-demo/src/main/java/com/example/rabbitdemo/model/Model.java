package com.example.rabbitdemo.model;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author disfang
 */
@Table(name = "model")
@Data
public class Model implements Serializable {

    private Integer id;

    private String name;

    private String password;

}