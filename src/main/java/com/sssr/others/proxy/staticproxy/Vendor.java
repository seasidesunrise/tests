package com.sssr.others.proxy.staticproxy;

/**
 * 委托类，生产厂家
 */
public class Vendor implements Sell {

    public void sell() {
        System.out.println("In sell method");
    }

    public void ad() {
        System.out.println("ad method");
    }

}
