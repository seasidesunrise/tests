package com.sssr.others.volatil;

public class Singleton {

    private static Singleton instance = null;

    private String name = "A";

    private Singleton() {
        System.out.printf("new Singleton");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                    instance.name = "B";
                }
            }
        }

        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
