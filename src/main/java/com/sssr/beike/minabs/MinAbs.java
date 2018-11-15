package com.sssr.beike.minabs;

/**
 * 给定一个数组，设计一个查找绝对值最小的数的算法
 */
public class MinAbs {

    public static void main(String[] args) throws Exception {
        int[] array = {100, 34, 345, 21, 3, -394, -31, -9};

        int minAbs = Math.abs(array[0]);
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            int tempAbs = Math.abs(array[i]);
            if (tempAbs < minAbs) {
                minAbs = tempAbs;
                index = i;
            }
        }

        System.out.println("index:" + index + ", value:" + minAbs);
    }

}
