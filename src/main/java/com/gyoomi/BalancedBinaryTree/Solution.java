/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.BalancedBinaryTree;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-09-27 17:25
 */
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

