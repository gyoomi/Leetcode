## 111. 二叉树的最小深度

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

```java

    3
   / \
  9  20
    /  \
   15   7
```

返回它的最小深度 2.


**方法 1：递归**

**算法**

最直接的思路就是递归。

我们用深度优先搜索来解决这个问题。

**代码**

```java

public class Solution {

    public int minDepth(TreeNode root) {

        // The export of special case
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 防止整型的溢出
        int minDepth = Integer.MAX_VALUE;

        // 深度优先的进行递归
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
    }
}
```

**复杂度分析**

- 时间复杂度：我们访问每个节点一次，时间复杂度为 O(N) ，其中 N 是节点个数。
- 空间复杂度：最坏情况下，整棵树是非平衡的，例如每个节点都只有一个孩子，递归会调用 N （树的高度）次，因此栈的空间开销是 O(N) 。但在最好情况下，树是完全平衡的，高度只有 log(N)，因此在这种情况下空间复杂度只有 O(log(N)) 。































