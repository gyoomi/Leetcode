/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.other;

/**
 * 题目：两个有序list,求交集
 *
 *       思路一：for * for，土办法，时间复杂度O(n*n)
 *               test01(int[] arr1, int[] arr2)
 *
 *       思路二：拉链法
 *               两个指针指向首元素，比较元素的大小：
 * 　　　　     （1）如果相同，放入结果集，随意移动一个指针
 * 　　　　     （2）否则，移动值较小的一个指针，直到队尾
 *
 *               这种方法的好处是：
 * 　　            （1）集合中的元素最多被比较一次，时间复杂度为O(n)
 * 　　            （2）多个有序集合可以同时进行，这适用于多个分词的item求url_id交集
 * 　　             这个方法就像一条拉链的两边齿轮，一一比对就像拉链，故称为拉链法
 *        思路三：跳表进行实现
 *                参考https://blog.csdn.net/bohu83/article/details/83654524 文章进行实现
 *
 * @author Leon
 * @version 2019/5/30 11:01
 */
public class Main01 {

    public static void main(String[] args) throws Exception {
        int[] arr1 = {1, 3, 5, 7, 8, 9};
        int[] arr2 = {2, 3, 4, 5, 6, 7};
        test02(arr1, arr2);
    }

    public static void test01(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.println(arr1[i]);
                }
            }
        }
    }

    public static void test02(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                System.out.println(arr1[i]);
                i++;
            } else {
                if (arr1[i] < arr2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
    }
}
