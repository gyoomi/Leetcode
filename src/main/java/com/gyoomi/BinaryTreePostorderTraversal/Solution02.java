/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.BinaryTreePostorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-10-09 16:35
 */
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
