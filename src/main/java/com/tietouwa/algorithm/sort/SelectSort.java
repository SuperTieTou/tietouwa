package com.tietouwa.algorithm.sort;

import com.tietouwa.algorithm.util.SortTestUtil;

import java.util.Optional;

public class SelectSort {

    public static void main(String[] args) {
        SortTestUtil.testSort(SelectSort::selectSort);
        System.out.println("10000单位数组排序平均耗时毫秒:" + SortTestUtil.calcTimeConsume(SelectSort::selectSort));
    }

    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, minIndex, i);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i  == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


}
