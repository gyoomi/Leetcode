## 108. 将有序数组转换为二叉搜索树

将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例：

```text
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

```

方法1： 二分法 + 递归处理

```java

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return convertToTree(nums, 0, nums.length);
    }

    private TreeNode convertToTree(int[] nums, int left, int right) {
        // 定义的二分区间为[left, right]，无法进行继续递归，直接退出
        if (left >= right) {
            return null;
        }
        // 这样写内存不够
        // int mid = (right + (left - right)) / 2;
        // int mid = (left + (right - left)) >> 1;

        // 这样写有风险
        int mid = (right + left) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convertToTree(nums, left, mid);
        root.right = convertToTree(nums, mid + 1, right);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
```





































