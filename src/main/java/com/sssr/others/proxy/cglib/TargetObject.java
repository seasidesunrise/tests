package com.sssr.others.proxy.cglib;

/**
 * @author zhaojun.wzj
 * @version $Id TargetObject.java, v 0.1 2018-10-29 15:15 zhaojun.wzj Exp $$
 */
public class TargetObject {

    public String method1(String paramName) {
        return paramName;
    }

    public int method2(int count) {
        return count;
    }

    public int method3(int count) {
        return count;
    }

    @Override
    public String toString() {
        return "TargetObject []" + getClass();
    }

}