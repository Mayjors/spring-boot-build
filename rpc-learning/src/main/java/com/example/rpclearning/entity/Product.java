package com.example.rpclearning.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author yuanjie
 * @date 2018/9/29 18:00
 */
@Data
public class Product {
    @Id
    private Long id;

    private String name;

    private String price;
}
