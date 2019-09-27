## 110. 平衡二叉树

给定一个二叉树，判断它是否是高度平衡的二叉树.

本题中，一棵高度平衡二叉树定义为：
>一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。


示例 1:

给定二叉树 [3,9,20,null,null,15,7]

```java
   3
   / \
  9  20
    /  \
   15   7
```

返回true

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

```java
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```

返回false

**从底至顶（提前阻断法）**

>对二叉树做深度优先遍历DFS，递归过程中：
>终止条件：当DFS越过叶子节点时，返回高度0；
>返回值：
>从底至顶，返回以每个节点root为根节点的子树最大高度(左右子树中最大的高度值加1max(left,right) + 1)；
>当我们发现有一例 左/右子树高度差 ＞ 1 的情况时，代表此树不是平衡树，返回-1；
>当发现不是平衡树时，后面的高度计算都没有意义了，因此一路返回-1，避免后续多余计算。
>最差情况是对树做一遍完整DFS，时间复杂度为 O(N)。

**代码**

```java
public class Solution {

    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = depth(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = depth(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        return Math.abs(leftHeight - rightHeight) <= 1? Math.max(leftHeight, rightHeight) + 1 : -1;
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









































