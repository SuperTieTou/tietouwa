package com.tietouwa.algorithm.sort;

import com.tietouwa.algorithm.util.SortTestUtil;

public class InsertSort {

    public static void main(String[] args) {
        SortTestUtil.testSort(InsertSort::insertSort);
        System.out.println("10000单位数组排序平均耗时毫秒:" + SortTestUtil.calcTimeConsume(InsertSort::insertSort));
    }

    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int i1 = i; i1 > 0 && arr[i1 - 1] > arr[i1]; i1--) {
                swap(arr, i1 - 1, i1);
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
