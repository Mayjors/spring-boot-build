package com.example.rabbitdemo.service;

import com.example.rabbitdemo.model.People;
import com.example.rabbitdemo.model.Work;

import java.util.List;

/**
 * @author yuanjie
 * @date 2018/10/29 16:18
 */
public interface WorkService {

    Work findById(int id);

    Work findByName(String name);

    List<Work> findAll();

    void insertOne(Work work);

    int update(Work work);
}
