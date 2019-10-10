/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.SumRoottoLeafNumbers;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-10-10 15:07
 */
public class Solution {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root, 0);
    }

    private int sum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum = sum * 10 + node.val;
        // 递归出口
        if (node.left == null && node.right == null) {
            return sum;
        }
        return sum(node.left, sum) + sum(node.right, sum);
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
