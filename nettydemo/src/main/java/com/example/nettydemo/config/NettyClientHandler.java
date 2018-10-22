package com.example.nettydemo.config;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author yuanjie
 * @date 2018/10/17 17:42
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("收到服务端消息：" + s);
    }
}
