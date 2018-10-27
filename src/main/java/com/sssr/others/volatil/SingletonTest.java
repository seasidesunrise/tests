package com.sssr.others.volatil;

public class SingletonTest {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    Singleton instance = Singleton.getInstance();

                    System.out.println(instance.getName());
                }
            }.start();
        }
    }

}
