## 100. 相同的树

给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:

```
输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
```

示例 2:

```
输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false
```


**方法一：递归**

**思路**

直觉

最简单的策略是使用递归。首先判断 p 和 q 是不是 None，然后判断它们的值是否相等。
若以上判断通过，则递归对子结点做同样操作。

**代码**

```java
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) {
            return true;
        }
        // one of p and q is null
        if (p == null | q == null) {
            return false;
        }
        // compare p and q value
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {

    }


}

```

复杂度分析

- 时间复杂度 : O(N)，其中 N 是树的结点数，因为每个结点都访问一次。
- 空间复杂度 : 最优情况（完全平衡二叉树）时为 O(log(N))，最坏情况下（完全不平衡二叉树）时为 O(N)，用于维护递归栈。































