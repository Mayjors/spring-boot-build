package com.example.nettydemo.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author yuanjie
 * @date 2018/10/17 16:57
 */
@Slf4j
@Component
public class NettyServer {
    private int port = 1000;

    public void run() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);
            serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
            serverBootstrap.childOption(ChannelOption.TCP_NODELAY, true);
            serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
            serverBootstrap.childHandler(new NettyServerInitializer());
            // 绑定端口，开始接收进来的连接
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            log.info("netty 服务启动");
            // 等待服务器socket关闭
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            log.error("netty 服务启动异常 --" + e.getMessage());
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
