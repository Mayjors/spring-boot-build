package com.example.rpclearning.service;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author yuanjie
 * @date 2018/9/26 15:32
 */
@Component
public class ZkServiceImpl implements Watcher, ServiceRegistry {
    private static final int SESSION_TIMEOUT = 5000;
    private static final String REGISTRY_PATH = "/mayjors";
    private static CountDownLatch latch = new CountDownLatch(1);

    private ZooKeeper zk;

    @Override
    public void process(WatchedEvent event) {

    }

    @Override
    public void register(Registration registration) {

    }

    @Override
    public void deregister(Registration registration) {

    }

    @Override
    public void close() {

    }

    @Override
    public void setStatus(Registration registration, String status) {

    }

    @Override
    public Object getStatus(Registration registration) {
        return null;
    }
}
