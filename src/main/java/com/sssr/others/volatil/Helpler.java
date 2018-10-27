package com.sssr.others.volatil;

import java.io.Serializable;

public class Helpler implements Serializable {

    private String name = "A";

    public Helpler() {
        System.out.printf("const helper");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
