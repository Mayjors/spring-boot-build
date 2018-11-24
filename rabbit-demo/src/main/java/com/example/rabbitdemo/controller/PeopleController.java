package com.example.rabbitdemo.controller;

import com.example.rabbitdemo.model.People;
import com.example.rabbitdemo.service.PeopleService;
import com.example.util.result.ResultMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuanjie
 * @date 2018/10/29 16:25
 */
@RestController
@RequestMapping("people")
public class PeopleController {

    @Resource
    private PeopleService peopleService;

    @RequestMapping("insert")
    public ResultMessage inset() {
        People people = new People();
        people.setName("name");
        people.setAge(12);

        peopleService.insertOne(people);
        return new ResultMessage();
    }

    @RequestMapping("update")
    public ResultMessage update() {
        People people = new People();
        people.setId(1);
        people.setName("zzz");
        people.setAge(12);
        int i = peopleService.update(people);

        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setData(i);
        return resultMessage;
    }

    @RequestMapping("findByName")
    public ResultMessage findByName(String name) {
        People people = peopleService.findByName(name);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setData(people);
        return resultMessage;
    }

    @RequestMapping("findById")
    public ResultMessage findById(Integer id) {
        People people = peopleService.findById(id);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setData(people);
        return resultMessage;
    }

    @RequestMapping("findAll")
    public ResultMessage findAll() {
        List<People> list = peopleService.findAll();
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setData(list);
        return resultMessage;
    }

}
