package com.sssr.others.proxy.staticproxy;

/**
 * @author zhaojun.wzj
 * @version $Id StaticProxyTest.java, v 0.1 2018-10-29 11:36 zhaojun.wzj Exp $$
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        Vendor vendor = new Vendor();
        BusinessAgent agent = new BusinessAgent(vendor);
        agent.sell();
        System.out.println();
        agent.ad();
    }
}