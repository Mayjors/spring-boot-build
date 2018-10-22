package com.example.rpclearning.provider;

import com.alibaba.fastjson.JSON;
import com.example.rpclearning.beans.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * 消息发送
 * @author yuanjie
 * @date 2018/9/25 19:17
 */
@Slf4j
@Component
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("++++++++++++++ >>>>> message = {}", JSON.toJSONString(message));
        kafkaTemplate.send("zhisheng", JSON.toJSONString(message));
    }
}
