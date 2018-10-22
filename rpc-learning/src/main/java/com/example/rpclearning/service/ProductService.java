package com.example.rpclearning.service;

import com.example.rpclearning.entity.Product;

import java.util.List;

/**
 * @author yuanjie
 * @date 2018/9/29 18:10
 */
public interface ProductService {
    Product select(long productId);

    Product update(long productId, Product newProduct);

    List<Product> getAllProduct();
}
