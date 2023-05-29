package com.tietouwa.algorithm.util;

import java.util.Arrays;
import java.util.function.Consumer;

public class SortTestUtil {

    public static void testSort(Consumer<int[]> consumer) {
        int testTime = 5000;
        int maxSize = 1000;
        int maxValue = 1000;

        for (int i = 0; i < testTime; i++) {
            //随机生成排序组
            int[] arr = RandomArrayUtil.generateRandomSizeValueArray(maxSize, maxValue);
            int[] arr1 = copyArr(arr);
            int[] arr2 = copyArr(arr);

            //排序
            consumer.accept(arr1);

            //创建对照组并检查
            Arrays.sort(arr2);
            if (!compare(arr1, arr2)) {
                System.out.println("排序有误" + i);
                printArray(arr2);
                printArray(arr1);
                return ;
            }
        }

        System.out.println("排序无误");
    }

    /**
     * 单次排序太快了 计算结果都是0 这里计算1000次 返回平均值
     * @return
     */
    public static double calcTimeConsume(Consumer<int[]> consumer) {
        int times = 10;
        int maxValue = 10000;
        int[][] arrays = new int[times][maxValue];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = RandomArrayUtil.generateRandomValueArray(maxValue, maxValue);
        }
        long l1 = System.currentTimeMillis();
        for (int[] arr : arrays) {
            consumer.accept(arr);
        }
        long l2 = System.currentTimeMillis();
        return (l2 - l1) / (float)times;
    }

    public static boolean compare(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }



    private static int[] copyArr(int[] arr1) {
        return Arrays.copyOf(arr1, arr1.length);
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static int[] sort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        testSort(SortTestUtil::sort);
        System.out.println("10000单位数组排序平均耗时毫秒:" + SortTestUtil.calcTimeConsume(SortTestUtil::sort));
    }

}
