package com.example.manager.controller;

import com.example.manager.model.User;
import com.example.manager.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yuanjie
 * @date 2018/9/17 18:32
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int addUser() {
        User user = new User();
        user.setUserName("name1");
        user.setPassword("123");
        user.setPhone("123456789");
        return userService.addUser(user);
    }

    @RequestMapping(value = "/all/{pageNum}/{pageSize}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }

}
