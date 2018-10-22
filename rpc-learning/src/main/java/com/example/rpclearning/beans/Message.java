package com.example.rpclearning.beans;

import lombok.Data;

import java.util.Date;

/**
 * @author yuanjie
 * @date 2018/9/25 19:16
 */
@Data
public class Message {
    private Long id;
    private String msg;

    private Date sendTime;
}
