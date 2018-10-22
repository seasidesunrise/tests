package com.sssr.jd.intconvert;

public class IntConvert {

    public static void main(String[] args) throws Exception {
        // 将一个null的包装类赋值给整形，抛出空指针异常。这里有一个语法糖的操作
        int a = 1;
        Integer b = null;

        a = b;
        System.out.println(a);
    }

}
