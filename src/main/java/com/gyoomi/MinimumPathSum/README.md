## 64. 最小路径和

给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

**示例:**

```
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

```

**方法 1： 暴力**

暴力就是利用递归，对于每个元素我们考虑两条路径，向右走和向下走，在这两条路径中挑选路径权值和较小的一个。

```
cost(i,j) = grid[i][j] + min(cost(i+1,j),cost(i,j+1))
```

```java
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
```

**复杂度分析**

- 时间复杂度 ：O(2^m+n)。每次移动最多可以有两种选择。
- 空间复杂度 ：O(m+n)。递归的深度是 m+n。

























