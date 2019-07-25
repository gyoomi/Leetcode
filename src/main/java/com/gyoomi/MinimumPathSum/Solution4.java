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
 * @version 2019/7/25 14:26
 */
public class Solution4 {

    public int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j + 1], grid[i + 1][j]);
                }
            }
        }
        return grid[0][0];
    }
}
