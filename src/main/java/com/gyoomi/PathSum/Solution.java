/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.PathSum;


/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/9/4 15:09
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
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












