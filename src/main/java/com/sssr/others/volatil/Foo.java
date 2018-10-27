package com.sssr.others.volatil;

public class Foo {
    private static Helpler helpler = null;

    public static Helpler getHelpler() {
        if (helpler == null) {
            synchronized (Foo.class) {
                if (helpler == null) {
                    helpler = new Helpler();
                }
            }
        }
        return helpler;
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 100; i++) {
            new Thread() {
                public void run() {
                    Helpler helpler = Foo.getHelpler();
                    System.out.println(helpler.getName());
                }
            }.start();
        }
    }
}
