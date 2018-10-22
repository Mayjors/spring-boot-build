package com.example.nettydemo.config;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * netty服务监听器
 * @author yuanjie
 * @date 2018/10/17 17:21
 */
public class NettyServerListener implements ServletContextListener {
    @Autowired
    private NettyServer nettyServer;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Thread thread = new Thread(new NettyServerThread());
        // 启动netty服务
        thread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


    /**
     * netty服务启动线程 . <br>
     *
     * @author hkb
     */
    private class NettyServerThread implements Runnable {

        @Override
        public void run() {
            nettyServer.run();
        }
    }
}
