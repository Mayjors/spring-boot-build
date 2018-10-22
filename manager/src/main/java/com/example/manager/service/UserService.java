package com.example.manager.service;

import com.example.manager.model.User;

import java.util.List;

/**
 * @author yuanjie
 * @date 2018/9/17 18:27
 */
public interface UserService {
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}
