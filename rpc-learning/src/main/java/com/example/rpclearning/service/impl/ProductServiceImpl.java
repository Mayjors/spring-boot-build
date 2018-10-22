package com.example.rpclearning.service.impl;

import com.example.rpclearning.dao.ProductDao;
import com.example.rpclearning.entity.Product;
import com.example.rpclearning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuanjie
 * @date 2018/9/29 18:10
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product select(long productId) {
        return productDao.select(productId);
    }

    @Override
    public Product update(long productId, Product newProduct) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }
}
