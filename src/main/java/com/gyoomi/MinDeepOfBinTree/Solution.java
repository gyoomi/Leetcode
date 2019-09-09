package com.gyoomi.MinDeepOfBinTree;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/9/9 22:47
 */
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
