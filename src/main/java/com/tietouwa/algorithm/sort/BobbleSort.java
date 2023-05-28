package com.tietouwa.algorithm.sort;

import com.tietouwa.algorithm.util.SortTestUtil;

public class BobbleSort {

    public static void main(String[] args) {
        SortTestUtil.testSort(BobbleSort::bobbleSort);
        System.out.println("10000单位数组排序平均耗时毫秒:" + SortTestUtil.calcTimeConsume(BobbleSort::bobbleSort));
    }

    public static int[] bobbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr.length - i; i1++) {
                if (arr[i1] > arr[i1 + 1]) {
                    swap(arr, i1, i1 + 1);
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
