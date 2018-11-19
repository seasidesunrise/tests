package com.sssr.multithreading.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class CachedThreadPool {

    public static void main(String[] args) {
//        ExecutorService es = Executors.newCachedThreadPool();
//        ExecutorService es = Executors.newFixedThreadPool(10);

        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

        ExecutorService es = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 100; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        es.shutdown();
    }

}
