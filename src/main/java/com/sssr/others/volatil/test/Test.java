package com.sssr.others.volatil.test;

public class Test {

    public static void main(String[] args) {

        Thread r = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Suo.sss);
            }
        };

        r.start();

        synchronized (Suo.class) {
            try {
                System.out.println("fd");
                Thread.sleep(1000);
                System.out.println("fd");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
