/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.BinaryTreeMaximumPathSum;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-10-09 16:56
 */
public class Solution {

    int maxNum = Integer.MIN_VALUE;

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 左右两个子树的最大路径和
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 当前节点的最大路径和
        int newPathSum = node.val + leftGain + rightGain;

        // 更新为两者中较大的那个
        maxNum = Math.max(newPathSum, maxNum);
        // 否则进行递归处理，获取最大路径和值
        return node.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxNum;
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
