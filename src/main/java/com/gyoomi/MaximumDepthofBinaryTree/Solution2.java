/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.MaximumDepthofBinaryTree;

import java.util.Stack;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/9/4 14:34
 */
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
