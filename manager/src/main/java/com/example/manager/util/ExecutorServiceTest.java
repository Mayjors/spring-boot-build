package com.example.manager.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yuanjie
 * @date 2018/10/8 15:05
 */
public class ExecutorServiceTest {
    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("asdfdfg");
            }
        });
        executorService.shutdown();
    }
}
