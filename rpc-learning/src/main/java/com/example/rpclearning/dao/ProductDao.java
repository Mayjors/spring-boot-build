package com.example.rpclearning.dao;

import com.example.rpclearning.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yuanjie
 * @date 2018/9/29 18:02
 */
@Mapper
public interface ProductDao {
    Product select(@Param("id") Long id);

    Integer update(Product product);

    List<Product> getAllProduct();
}
