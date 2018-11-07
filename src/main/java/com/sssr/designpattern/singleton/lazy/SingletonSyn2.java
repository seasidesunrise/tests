package com.sssr.designpattern.singleton.lazy;

import java.util.concurrent.CountDownLatch;

/**
 * 懒汉式单例，线程安全
 *
 * @author zhaojun.wzj
 * @version $Id Singleton.java, v 0.1 2018-11-07 11:54 zhaojun.wzj Exp $$
 */
public class SingletonSyn2 {

    /** 实例个数，用于测试验证 */
    private static int threadCount = 0;

    /**
     * 构造函数
     */
    private SingletonSyn2() {
        threadCount++;
    }

    /** 单例对象 */
    private static SingletonSyn2 singleton = null;

    /**
     * 获取单例对象方法，线程安全
     *
     * @return
     */
    public static SingletonSyn2 getInstance() {
        synchronized (SingletonSyn2.class) {
            if (singleton == null) {
                singleton = new SingletonSyn2();
            }
        }

        return singleton;
    }

    /**
     * 测试线程安全
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int threadCount = 2;
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

                    SingletonSyn2 s = SingletonSyn2.getInstance();
                    System.out.println("threadCount:" + s.threadCount + ", time:" + System.nanoTime());
                }
            }.start();

            latch.countDown();
        }

    }

}