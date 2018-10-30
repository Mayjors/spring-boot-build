package com.example.rabbitdemo.service.impl;

import com.example.rabbitdemo.mapper.ModelMapper;
import com.example.rabbitdemo.model.Model;
import com.example.rabbitdemo.service.ModelService;
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
public class ModelServiceImpl implements ModelService {
    @Resource
    private ModelMapper modelMapper;

    @Override
    public Model findById(int id) {
        Model model = modelMapper.selectById(id);
        return model;
    }

    @Override
    public Model findByName(String name) {
        Model model = modelMapper.findByName(name);
        return model;
    }

    @Override
    public List<Model> findAll() {
        List<Model> list = modelMapper.findAll();
        return list;
    }

    @Override
    public void insertOne(Model model) {
        modelMapper.insertOne(model);
    }

    @Override
    public int update(Model model) {
        modelMapper.update(model);
        return 0;
    }
}
