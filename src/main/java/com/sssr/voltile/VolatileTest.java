package com.sssr.voltile;

/**
 * volatile: 从heap内存加载到cpu高速缓存后，如果发生了变更，cpu高速缓存会reload。不
 * 使用volatile修饰的属性不会。以下是例子。与synchronize的区别是：synchronize提供原
 * 子性和可见性，volatile只提供可见性。
 *
 * 参考：http://www.cnblogs.com/dolphin0520/p/3920373.html
 *
 * @author zhaojun.wzj
 * @version $Id VolatileTest.java, v 0.1 2018-10-26 16:23 zhaojun.wzj Exp $$
 */
public class VolatileTest extends Thread {

    boolean      flag = false;

    volatile int i    = 0;

    public void increase() {
        i++;
    }

    public void run() {
        while (!flag) {
            i++;
        }
        System.out.println("exit:" + i);
    }

    public static void main(String[] args) throws Exception {
        VolatileTest vt = new VolatileTest();
        vt.start();
        Thread.sleep(100);
        vt.flag = true;
        System.out.println("stope:" + vt.i);

        Thread.sleep(500);
        System.out.println("end:" + vt.i);
        Thread.sleep(500);
        System.out.println("end2:" + vt.i);

        Thread.sleep(500);
        System.out.println("end3:" + vt.i);

        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        vt.increase();
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println("end4:" + vt.i);
    }

}