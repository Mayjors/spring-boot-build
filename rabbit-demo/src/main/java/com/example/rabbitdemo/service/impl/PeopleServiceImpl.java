package com.example.rabbitdemo.service.impl;

import com.example.rabbitdemo.mapper.PeopleMapper;
import com.example.rabbitdemo.model.People;
import com.example.rabbitdemo.sender.HelloSender;
import com.example.rabbitdemo.service.PeopleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuanjie
 * @date 2018/10/29 16:20
 */
@Service
@Transactional
public class PeopleServiceImpl implements PeopleService {
    @Resource
    private PeopleMapper peopleMapper;
    @Resource
    private HelloSender helloSender;

    @Override
    public People findById(int id) {
        People people = peopleMapper.selectById(id);
        return people;
    }

    @Override
    public People findByName(String name) {
        People people = peopleMapper.findByName(name);
        helloSender.sendObj(people);
        return people;
    }

    @Override
    public List<People> findAll() {
        List<People> list = peopleMapper.findAll();
        return list;
    }

    @Override
    public void insertOne(People people) {
        peopleMapper.insertOne(people);
    }

    @Override
    public int update(People people) {
        peopleMapper.update(people);
        return 0;
    }
}
