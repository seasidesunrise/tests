package com.sssr.advance.intarray;

/**
 * 找出某个整数数组中唯一的重复数字
 */
public class FindDuplicateNumber {

    /**
     * 对未排序的整数数组，找出某个整数数组中唯一的重复数字
     *
     * @param intArr
     * @return
     */
    public static Integer findDuplicateNum(int[] intArr) {
        if (intArr == null || intArr.length == 0) {
            return null;
        }

        int size = intArr.length;
        int sum = 0;
        for (int i = 0; i < intArr.length; i++) {
            sum += intArr[i];
        }
        int sum2 = size * (size + 1) / 2;
        int tmp = sum2 - sum;

        return size - tmp;
    }

    /**
     * 对已排序的整数数组，找出某个整数数组中唯一的重复数字
     *
     * @param intArr
     * @return
     */
    public static Integer findDuplicateNum2(int[] intArr) {
        if (intArr == null || intArr.length == 0) {
            return null;
        }

        int startNum = 0;
        int endNum = intArr.length - 1;

        while (endNum - startNum > 1) {
            int num = (endNum + startNum) / 2;
            int value = intArr[num];

            if (value < num + 1) {
                endNum = num;
            } else {
                startNum = num;
            }
        }
        return endNum;
    }

}
