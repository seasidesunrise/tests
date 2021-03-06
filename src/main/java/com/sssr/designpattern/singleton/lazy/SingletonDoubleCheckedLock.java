package com.sssr.designpattern.singleton.lazy;

import java.util.concurrent.CountDownLatch;

/**
 * 懒汉式单例，线程安全
 *
 * @author zhaojun.wzj
 * @version $Id Singleton.java, v 0.1 2018-11-07 11:54 zhaojun.wzj Exp $$
 */
public class SingletonDoubleCheckedLock {

    /** 实例个数，用于测试验证 */
    private static int threadCount = 0;

    /**
     * 构造函数
     */
    private SingletonDoubleCheckedLock() {
        threadCount++;
    }

    /** 单例对象，加上volatile防止多线程情况下因指令重排序发生异常 */
    private static volatile SingletonDoubleCheckedLock singleton = null;

    /**
     * 获取单例对象方法，线程安全
     *
     * @return
     */
    public static SingletonDoubleCheckedLock getInstance() {
        if (singleton == null) {
            synchronized (SingletonDoubleCheckedLock.class) {
                if (singleton == null) {
                    singleton = new SingletonDoubleCheckedLock();
                }
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

                    SingletonDoubleCheckedLock s = SingletonDoubleCheckedLock.getInstance();
                    System.out.println("threadCount:" + s.threadCount + ", time:" + System.nanoTime());
                }
            }.start();

            latch.countDown();
        }

    }

}