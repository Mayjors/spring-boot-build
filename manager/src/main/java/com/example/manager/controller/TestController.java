package com.example.manager.controller;

import com.example.manager.model.People;
import com.example.util.result.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanjie
 * @date 2018/9/17 18:25
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private People people;

    @RequestMapping("/hi")
    public ResultMessage hi() {

        System.out.println(people.getId());
        return new ResultMessage("ssd");
    }

}
