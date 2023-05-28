package com.tietouwa.algorithm.util;

public class RandomArrayUtil {

    public static int[] generateRandomSizeValueArray(int maxSize, int maxValue) {
        return generateRandomValueArray((int)((maxSize + 1) * Math.random()), maxValue);
    }

    public static int[] generateRandomValueArray(int size, int maxValue) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random());
        }
        return arr;
    }

}
