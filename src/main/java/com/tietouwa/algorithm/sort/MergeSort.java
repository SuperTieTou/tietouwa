package com.tietouwa.algorithm.sort;

import com.tietouwa.algorithm.util.SortTestUtil;

public class MergeSort {

    public static void main(String[] args) {
        SortTestUtil.testSort(MergeSort::sort);
        System.out.println("10000单位数组排序平均耗时毫秒:" + SortTestUtil.calcTimeConsume(MergeSort::sort));

        SortTestUtil.testSort(MergeSort::sortNoRecursion);
        System.out.println("10000单位数组排序平均耗时毫秒:" + SortTestUtil.calcTimeConsume(MergeSort::sortNoRecursion));
    }

    public static void sort(int[] arr) {
        if (arr ==  null || arr.length == 0) return;
        sort(arr, 0, arr.length - 1);
    }

    public static void sortNoRecursion(int[] arr) {
        if (arr ==  null || arr.length == 0) return;
        int mergeSize = 1;
        while (mergeSize < arr.length) {
            int l = 0;
            while (l < arr.length) {
                int mid = l + mergeSize - 1;
                int r = Math.min(mid + mergeSize, arr.length - 1);
                if (mid < r) {
                    marge(arr, l, r, mid);
                }
                l = r + 1;
            }

            //防止mergeSize <<= 1 超过int.MAX
            if (mergeSize > arr.length / 2) {
                break;
            }

            mergeSize <<= 1;
        }

    }

    public static void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        //int mid = l + ((r - l) >> 2);
        //可能是数据大小原因 对数器实测写成2更快
        int mid = l + ((r - l) >> 1);

        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        marge(arr, l, r, mid);
    }

    private static void marge(int[] arr, int l, int r, int mid) {
        int[] temp = new int[r - l + 1];
        int tempIndex = 0;
        int opl = l;
        int opr = mid + 1;

        while (opl <= mid || opr <= r) {
            if (opr > r) {
                temp[tempIndex++] = arr[opl++];
            } else if (opl > mid) {
                temp[tempIndex++] = arr[opr++];
            } else if (arr[opl] < arr[opr]) {
                temp[tempIndex++] = arr[opl++];
            } else {
                temp[tempIndex++] = arr[opr++];
            }
        }
        for (int i = 0; i <= r - l; i++) {
            arr[i + l] = temp[i];
        }
    }

}
