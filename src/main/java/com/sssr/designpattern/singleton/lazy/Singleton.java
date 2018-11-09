package com.sssr.designpattern.singleton.lazy;

import java.util.concurrent.CountDownLatch;

/**
 * 初级懒汉式单例，非线程安全
 *
 * @author zhaojun.wzj
 * @version $Id Singleton.java, v 0.1 2018-11-07 11:54 zhaojun.wzj Exp $$
 */
public class Singleton {

    /** 实例个数，用于测试验证 */
    private static int threadCount = 0;

    /**
     * 构造函数
     */
    private Singleton() {
        threadCount++;
    }

    /** 单例对象 */
    private static Singleton singleton = null;

    /**
     * 获取单例对象方法，非线程安全
     *
     * @return
     */
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    /**
     * 测试非线程安全
     *
     * 同时可以看到，java虚拟机(相当于进程)退出的时机是：虚拟机中所有存活的线程都是守护线程。只要还有存活的
     * 非守护线程虚拟机就不会退出，而是等待非守护线程执行完毕；反之，如果虚拟机中的线程都是守护线程，那么不管
     * 这些线程的死活java虚拟机都会退出。
     * 新创建的thread默认是非守护线程。
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int threadCount = 10;
        CountDownLatch latch = new CountDownLatch(threadCount);
        int k = 0;
        for (; k < threadCount; k++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Singleton s = Singleton.getInstance();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("threadCount:" + s.threadCount + ", time:" + System.nanoTime());
                }
            }.start();

            latch.countDown();
        }

    }

}