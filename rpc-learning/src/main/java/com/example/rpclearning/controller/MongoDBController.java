package com.example.rpclearning.controller;

import com.example.rpclearning.dao.UserRepository;
import com.example.rpclearning.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuanjie
 * @date 2018/9/26 10:18
 */
@RestController
@RequestMapping("/mongo")
public class MongoDBController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/all")
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

}
