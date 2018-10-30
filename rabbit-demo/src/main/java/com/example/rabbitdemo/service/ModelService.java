package com.example.rabbitdemo.service;

import com.example.rabbitdemo.model.Model;

import java.util.List;

/**
 * @author yuanjie
 * @date 2018/10/29 16:18
 */
public interface ModelService {

    Model findById(int id);

    Model findByName(String name);

    List<Model> findAll();

    void insertOne(Model model);

    int update(Model model);
}
