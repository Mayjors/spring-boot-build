package com.example.rpclearning.controller;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanjie
 * @date 2018/9/26 14:52
 */
@RestController
@RequestMapping("/zookeeper")
public class RestZkController {

    @RequestMapping(value = "/zkGet",method = RequestMethod.GET)
    public String zkGet(){

        Watcher watcher= new Watcher(){
            @Override
            public void process(WatchedEvent event) {
                System.out.println("receive event："+event);
            }
        };
        String value = null;
        try {
            final ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2181", 999999, watcher);
            final byte[] data = zookeeper.getData("/mayjors", watcher, null);
            value = new String(data);
            zookeeper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "获取 node_1 节点值为 [" + value + "]";
    }

    @RequestMapping("/add")
    public String createZnode() {
        String s = new String();
        s.intern();

        return null;
    }
}
