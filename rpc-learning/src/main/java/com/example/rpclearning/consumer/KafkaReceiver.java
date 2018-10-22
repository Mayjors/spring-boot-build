package com.example.rpclearning.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 消费者 接收类
 * @author yuanjie
 * @date 2018/9/25 19:21
 */
@Slf4j
@Component
public class KafkaReceiver {

    @KafkaListener(topics = {"zhisheng"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("----------------recod = " + record);
            log.info("----------------message = " + message);
        }

    }
}
