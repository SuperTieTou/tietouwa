package com.tietouwa.algorithm.bitoperation;

public class BitOperation {

    public static void main(String[] args) {
        //交换
        int a1 = 7897546;
        int b1 = 5648979;
        a1 = a1 ^ b1;
        b1 = a1 ^ b1;
        a1 = a1 ^ b1;
        System.out.println(a1);
        System.out.println(b1);

        //取二进制中最后一个1
        int a2 = 54613546;
        int b2 = a2 & (~a2 + 1);
        System.out.println(b2);

        //一个数组中有一个数是奇数个其他是偶数个，取这个奇数
        int[] arr1 = {1,1,1,1,3,3,8,8,9,9,2,2,5,5,6,6,1};
        int xor1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            xor1 ^= arr1[i];
        }
        System.out.println(xor1);


        //一个数组中有两个数是奇数个其他是偶数个，取这两个奇数
        int[] arr2 = {1,1,1,1,3,3,8,8,9,9,2,2,5,5,6,6,1,99};
        int xor2 = 0;
        int right = 0;
        int one = 0;
        for (int i = 0; i < arr2.length; i++) {
            xor2 ^= arr2[i];
        }
        right = xor2 & (~xor2 + 1);
        for (int i = 0; i < arr2.length; i++) {
            if ((right & arr2[i]) == 0) {
                one ^= arr2[i];
            }
        }
        System.out.println(one + " " + (one ^ xor2));

        //数出二进制位1的个数
        int a3 = 54613549;
        int count1 = 0;
        while (a3 != 0) {
            a3 ^= a3 & (~a3 + 1);
            count1++;
        }
        System.out.println(count1);

    }
}
