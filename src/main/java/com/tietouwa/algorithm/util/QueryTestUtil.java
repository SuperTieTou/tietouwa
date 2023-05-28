package com.tietouwa.algorithm.util;

import java.util.Arrays;

public class QueryTestUtil {

    public interface QueryFunction {
        int queryIndex(int[] arr, int query);
    }

    public static void testQuery(QueryFunction function, boolean order) {
        int testTime = 5000;
        int maxSize = 1000;
        int maxValue = 1000;

        boolean isSuccess = false;

        for (int i = 0; i < testTime; i++) {
            //随机生成排序组
            int[] arr = RandomArrayUtil.generateRandomSizeValueArray(maxSize, maxValue);
            if (order) {
                sort(arr);
            }

            int queryKey = (int) ((maxValue + 1) * Math.random());

            int result = function.queryIndex(arr, queryKey);

            if (result == -1) {
                isSuccess = sequenceSearch(arr, queryKey) == -1;
            } else {
                isSuccess = arr[result] == queryKey;
            }

            if (!isSuccess) {
                printArray(arr);
                System.out.println("查询键:" + queryKey + "  返回值:" + result);
                System.out.println("正确结果为:" + sequenceSearch(arr, queryKey));
                System.out.println("查询有误");
                return;
            }

        }

        System.out.println("查询无误");
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static int[] sort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    private static int binarySearch(int[] arr, int queryKey) {
        int result = Arrays.binarySearch(arr, queryKey);
        return result < 0 ? -1 : result;
    }

    private static int sequenceSearch(int[] arr, int queryKey) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == queryKey) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        testQuery(QueryTestUtil::binarySearch, true);
        testQuery(QueryTestUtil::binarySearch, false);
    }

}
