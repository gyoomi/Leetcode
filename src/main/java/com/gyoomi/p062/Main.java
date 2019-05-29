/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.p062;

/**
 * 62. 不同路径
 *
 *     一个机器人位于一个 m * n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 *     问总共有多少条不同的路径？
 *     说明：m 和 n 的值均不超过 100。
 *
 *     例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 *     示例 1:
 *       输入: m = 3, n = 2
 *       输出: 3
 *       解释:
 *       从左上角开始，总共有 3 条路径可以到达右下角。
 *       1. 向右 -> 向右 -> 向下
 *       2. 向右 -> 向下 -> 向右
 *       3. 向下 -> 向右 -> 向右
 *
 *     示例 2:
 *       输入: m = 7, n = 3
 *       输出: 28
 *
 *     思路一：递归（超时）
 *     我们可以得知到第（i,j）格的方式为其上面格子的方式 + 左边的格子的方式
 *     即 Path（i, j） = Path(i-1, j) + Path(i, j-1)
 *
 *     思路二：动态规划
 *
 * @author Leon
 * @version 2019/5/29 14:14
 */

class Solution1 {

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 1;
                } else {
                    cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
                }
            }
        }
        return cache[m - 1][n -1];
    }
}

class Solution {

    public int uniquePaths(int m, int n) {
        if (m == 1|| n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

    }

}


























