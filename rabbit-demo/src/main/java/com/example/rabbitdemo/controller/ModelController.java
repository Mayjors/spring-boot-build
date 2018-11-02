package com.example.rabbitdemo.controller;

import com.example.rabbitdemo.model.Model;
import com.example.rabbitdemo.service.ModelService;
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
@RequestMapping("model")
public class ModelController {

    @Resource
    private ModelService modelService;

    @RequestMapping("insert")
    public ResultMessage inset() {
        Model model = new Model();
        model.setName("name");
        model.setPassword("123");

        modelService.insertOne(model);
        return new ResultMessage();
    }

    @RequestMapping("update")
    public ResultMessage update() {
        Model model = new Model();
        model.setId(1);
        model.setName("zzz");
        model.setPassword("222");
        int i = modelService.update(model);

        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setData(i);
        return resultMessage;
    }

    @RequestMapping("findByName")
    public ResultMessage findByName(String name) {
        Model model = modelService.findByName(name);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setData(model);
        return resultMessage;
    }

    @RequestMapping("findById")
    public ResultMessage findById(Integer id) {
        Model model = modelService.findById(id);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setData(model);
        return resultMessage;
    }

    @RequestMapping("findAll")
    public ResultMessage findAll() {
        List<Model> list = modelService.findAll();
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setData(list);
        return resultMessage;
    }

}
