package com.example.rabbitdemo.service;

import com.example.rabbitdemo.model.People;

import java.util.List;

/**
 * @author yuanjie
 * @date 2018/10/29 16:18
 */
public interface PeopleService {

    People findById(int id);

    People findByName(String name);

    List<People> findAll();

    void insertOne(People people);

    int update(People people);
}
