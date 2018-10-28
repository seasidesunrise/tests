package com.sssr.others.huisuo;

public class T {

    public static int aji(int[] arr, int i) {
        int i1 = i;//下一个值
        int i2;//最大值
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > i) {//大于基本值
                i2 = arr[j];//赋max值
                if (i1 > i2 || i == i1) {//第一次进来 i=i1<i2  所以把i2赋值给i1，以后i<i1 第二次进来 如果：i1>i2>i，则：所以把i2赋值给i1，否则不变
                    i1 = i2;
                }
            }
        }
        return i1;
    }

    public static void main(String[] args) {
        int[] arr = {44, 45, 450, 5, 43, 43, 78, 1, 434};
//        System.out.println(aji(arr, 4));
        System.out.println(calc(arr, 4));
    }

    public static int calc(int[] arr, int val) {
        int result = val;
        boolean changed = false;
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int justVal = val;
        for (int i = 0;i<arr.length;i++) {
            int temp = arr[i];
            if ((temp > val && temp < justVal) || !changed) {
                justVal = temp;
                result = temp;
                changed = true;
            }
        }
        return result;
    }
}
