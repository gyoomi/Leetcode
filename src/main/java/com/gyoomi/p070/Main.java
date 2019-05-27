/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.p070;

/**
 * 70. 爬楼梯
 *     假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *     每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *     注意：给定n是一个正整数。
 *
 *     示例 1：
 *       输入： 2
 *       输出： 2
 *       解释： 有两种方法可以爬到楼顶。
 *       1.  1 阶 + 1 阶
 *       2.  2 阶
 *     示例 2：
 *       输入： 3
 *       输出： 3
 *       解释： 有三种方法可以爬到楼顶。
 *       1.  1 阶 + 1 阶 + 1 阶
 *       2.  1 阶 + 2 阶
 *       3.  2 阶 + 1 阶
 *
 *      方法一：暴力法
 *     算法
 *
 *     在暴力法中，我们将会把所有可能爬的阶数进行组合，也就是 1 和 2 。
 *     而在每一步中我们都会继续调用 climbStairsclimbStairs 这个函数模拟爬 1 阶和 2 阶的情形，并返回两个函数的返回值之和。
 *
 *     climbStairs(i,n)=(i + 1, n) + climbStairs(i + 2, n)
 *     其中 i 定义了当前阶数，而 n 定义了目标阶数。
 *
 *     复杂度分析
 *     时间复杂度：O(2^n)，树形递归的大小为 2^n
 *     空间复杂度：O(n)，递归树的深度可以达到 n
 *
 *
 *
 *
 *
 *
 *
 * @author Leon
 * @version 2019/5/27 17:10
 */

class Solution1 {

    public int climbStairs(int n) {
        return climb(0, n);
    }

    private int climb(int i, int n) {
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        return climb(i + 1, n) + climb(i + 2, n);
    }

}




public class Main {

    public static void main(String[] args) throws Exception {

    }

}
























