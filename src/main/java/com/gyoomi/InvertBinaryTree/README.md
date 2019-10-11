## 226. 翻转二叉树

翻转一棵二叉树。

示例：

输入：

```text
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```

输出：

```text
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```


备注:

这个问题是受到 Max Howell 的 原问题 启发的 ：

>谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了

**方法1 （递归）** 

**思路**

反转一颗空树结果还是一颗空树。对于一颗根为 r，左子树为 \mbox{right}， 右子树为 \mbox{left} 的树来说，它的反转树是一颗根为 r，左子树为 \mbox{right} 的反转树，右子树为 \mbox{left} 的反转树的树。

**代码实现**

```java
public class Solution {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.right = left;
        root.left = right;
        return root;
    }

    /**
     * Definition for a binary tree node
     */
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

- 时间复杂度： 既然树中的每个节点都只被访问一次，那么时间复杂度就是 O(n)，其中 n 是树中节点的个数。在反转之前，不论怎样我们至少都得访问每个节点至少一次，因此这个问题无法做地比 O(n) 更好了。

- 空间复杂度： 本方法使用了递归，在最坏情况下栈内需要存放 O(h) 个方法调用，其中 h 是树的高度。由于 h∈O(n)，可得出空间复杂度为 O(n)。






































