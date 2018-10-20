package com.sssr.advance.intarray;

import org.junit.Test;

public class FindDuplicateNumberTest {

    @Test
    public void test1() {
        int[] intArray = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(FindDuplicateNumber.findDuplicateNum(intArray));
    }

    @Test
    public void test2() {
        int[] intArray = {1, 2, 2, 3};
        System.out.println(FindDuplicateNumber.findDuplicateNum(intArray));
    }

    @Test
    public void test3() {
        int[] intArray = {1, 2, 3, 4, 4, 5};
        System.out.println(FindDuplicateNumber.findDuplicateNum(intArray));
    }

    @Test
    public void test21() {
        int[] intArray = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(FindDuplicateNumber.findDuplicateNum2(intArray));
    }

    @Test
    public void test22() {
        int[] intArr = {1, 2, 3, 4, 4, 5};
        System.out.println(FindDuplicateNumber.findDuplicateNum2(intArr));
    }

    @Test
    public void test23() {
        int[] intArr = {1, 2, 2, 3};
        System.out.println(FindDuplicateNumber.findDuplicateNum2(intArr));
    }
}
