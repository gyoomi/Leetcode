## 104. 二叉树的最大深度

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：

给定二叉树 [3,9,20,null,null,15,7]，

```
    3
   / \
  9  20
    /  \
   15   7
```

返回它的最大深度 3 。


**方法一：递归**

直观的方法是通过递归来解决问题。在这里，我们演示了 DFS（深度优先搜索）策略的示例。

**代码**

```java
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
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

- 时间复杂度：我们每个结点只访问一次，因此时间复杂度为 O(N)，其中 N 是结点的数量。
- 空间复杂度：在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点，递归将会被调用 N 次（树的高度），因此保持调用栈的存储将是 O(N)。但在最好的情况下（树是完全平衡的），树的高度将是 log(N)。因此，在这种情况下的空间复杂度将是 O(log(N))。

**方法二：迭代**

我们还可以在栈的帮助下将上面的递归转换为迭代。

我们的想法是使用 DFS 策略访问每个结点，同时在每次访问时更新最大深度。

所以我们从包含根结点且相应深度为 1 的栈开始。然后我们继续迭代：将当前结点弹出栈并推入子结点。每一步都会更新深度。

代码

```java
public class Solution2 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int depth = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Integer temp = value.pop();
            depth = Math.max(temp, depth);
            if (node.left != null) {
                stack.push(node.left);
                value.push(temp + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                value.push(temp + 1);
            }
        }
        return depth;
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



































