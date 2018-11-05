package com.sssr.others.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author zhaojun.wzj
 * @version $Id TestCglib.java, v 0.1 2018-10-29 15:20 zhaojun.wzj Exp $$
 */
public class TestCglib {

    public static void main(String args[]) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        TargetObject targetObject2 = (TargetObject) enhancer.create();
//        System.out.println(targetObject2);
        System.out.println(targetObject2.method1("mmm1"));
//        System.out.println(targetObject2.method2(100));
//        System.out.println(targetObject2.method3(200));
    }

}