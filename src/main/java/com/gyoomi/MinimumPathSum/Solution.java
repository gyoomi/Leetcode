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
 * @version 2019/7/22 15:47
 */
public class Solution {

    public int calculate(int[][] grid, int i, int j) {
        if (grid.length == i || grid[0].length == j) {
            return Integer.MAX_VALUE;
        }
        if (grid.length - 1 == i && grid[0].length - 1 == j) {
            return grid[i][j];
        }
        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
    }

    public int minPathSum(int[][] grid) {
        return calculate(grid, 0, 0);
    }
}
