package com.tietouwa.algorithm.query;

import com.tietouwa.algorithm.util.QueryTestUtil;

public class BinarySearch {

    public static void main(String[] args) {
        QueryTestUtil.testQuery(BinarySearch::binarySearch, true);
        QueryTestUtil.testQuery(BinarySearch::binarySearchLeft, true);
    }

    public static int binarySearch(int[] arr, int key) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchLeft(int[] arr, int key) {
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == key) {
                index = mid;
                r = mid - 1;
            } else if (arr[mid] > key) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }

}
