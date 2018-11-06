package com.sssr.voltile;

/**
 * 参见：https://blog.csdn.net/SEU_Calvin/article/details/52370068
 *
 * @author zhaojun.wzj
 * @version $Id Test.java, v 0.1 2018-10-26 16:47 zhaojun.wzj Exp $$
 */
public class Test {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Test test = new Test();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        test.increase();
                    }
                };
            }.start();
        }

        while (Thread.activeCount() > 1) { //保证前面的线程都执行完
            Thread.yield();
        }

        System.out.println(test.inc);
    }

}
