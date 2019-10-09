## 145. 二叉树的后序遍历

给定一个二叉树，返回它的 后序 遍历。

示例:
```text
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
```

进阶: 递归算法很简单，你可以通过迭代算法完成吗？

**方法1：递归算法**

**代码实现**

```java
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(ans, root);
        return ans;
    }

    private void postOrder(List<Integer> ans, TreeNode root) {
        if (root != null) {
            postOrder(ans, root.left);
            postOrder(ans, root.right);
            ans.add(root.val);
        }
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

**方法2：迭代**

**思路**

从根节点开始依次迭代，弹出栈顶元素输出到输出列表中，然后依次压入它的所有孩子节点，按照从上到下、从左至右的顺序依次压入栈中。

因为深度优先搜索后序遍历的顺序是从下到上、从左至右，所以需要将输出列表逆序输出。

其实相当于前序遍历的逆向输出。算是一种取巧的方法。

**代码**

```java
public class Solution02 {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root != null) {
            stack.add(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            // 一直往头部添加
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
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

- 时间复杂度：访问每个节点恰好一次，因此时间复杂度为 O(N)，其中 N 是节点的个数，也就是树的大小。
- 空间复杂度：取决于树的结构，最坏情况需要保存整棵树，因此空间复杂度为 O(N)。





















