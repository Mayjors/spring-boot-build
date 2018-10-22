package com.example.rpclearning.controller;

import com.example.rpclearning.provider.KafkaSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yuanjie
 * @date 2018/9/25 19:24
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Resource
    private KafkaSender kafkaSender;

    @RequestMapping(value = "/sender", method = RequestMethod.GET)
    public String sender() {
        kafkaSender.send();
        return null;
    }

}
