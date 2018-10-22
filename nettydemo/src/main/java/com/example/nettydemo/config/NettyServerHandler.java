package com.example.nettydemo.config;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.Map;

/**
 * 服务端处理器
 * @author yuanjie
 * @date 2018/10/17 17:13
 */
@Slf4j
public class NettyServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        StringBuilder sb = null;
        Map<String, Object> result = null;
        try {
            // 报文解析处理
            sb = new StringBuilder();
            result = JSON.parseObject(s);
            sb.append(result);
            sb.append("解析成功").append("\n");
            channelHandlerContext.writeAndFlush(sb);
        } catch (Exception e) {
            String errorCode = "-1\n";
            channelHandlerContext.writeAndFlush(errorCode);
            log.error("报文解析失败： " + e.getMessage());
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        log.info("收到客户端[ip:" + clientIp + "]连接");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 当出现异常就关闭连接
        ctx.close();
    }

}
