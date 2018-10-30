package com.example.rabbitdemo.controller;

import com.example.rabbitdemo.sender.HelloSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yuanjie
 * @date 2018/10/30 15:44
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Resource
    private HelloSender helloSender;

    @RequestMapping("/send")
    public void send() {
        helloSender.send();
    }
}
