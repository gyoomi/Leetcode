/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.MinimumPathSum;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/7/24 16:29
 */
public class Solution3 {

    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j == grid[0].length - 1) {
                    dp[j] = grid[i][j];
                } else if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    // i != grid.length - 1 && j != grid[0].length
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}
