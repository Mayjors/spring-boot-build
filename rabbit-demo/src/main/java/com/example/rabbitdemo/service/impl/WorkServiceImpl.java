package com.example.rabbitdemo.service.impl;

import com.example.rabbitdemo.mapper.PeopleMapper;
import com.example.rabbitdemo.mapper.WorkMapper;
import com.example.rabbitdemo.model.People;
import com.example.rabbitdemo.model.Work;
import com.example.rabbitdemo.sender.HelloSender;
import com.example.rabbitdemo.service.PeopleService;
import com.example.rabbitdemo.service.WorkService;
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
public class WorkServiceImpl implements WorkService {
    @Resource
    private WorkMapper workMapper;
    @Resource
    private HelloSender helloSender;

    @Override
    public Work findById(int id) {
        Work work = workMapper.selectById(id);
        return work;
    }

    @Override
    public Work findByName(String name) {
        Work work = workMapper.findByName(name);
        return work;
    }

    @Override
    public List<Work> findAll() {
        List<Work> list = workMapper.findAll();
        return list;
    }

    @Override
    public void insertOne(Work work) {
        workMapper.insertOne(work);
    }

    @Override
    public int update(Work work) {
        workMapper.update(work);
        return 0;
    }
}
