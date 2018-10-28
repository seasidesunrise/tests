package com.sssr.others.volatil;

public class VolatileTest2 extends Thread {

    private boolean flag = false;
    int count = 0;

    public void run() {
        try {
            while (!flag) {
                Thread.sleep(100);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        VolatileTest2 t2 = new VolatileTest2();
        t2.start();
        Thread.sleep(1000);
        t2.flag = true;
        System.out.println(t2.count);
    }

    class A extends Thread {

    }

}
