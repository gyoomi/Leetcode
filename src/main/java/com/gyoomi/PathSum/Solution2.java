/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.PathSum;


import java.util.LinkedList;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/9/4 15:09
 */
public class Solution2 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> treeNodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        treeNodeStack.add(root);
        sumStack.add(sum - root.val);

        TreeNode node;
        int curSum;
        while (!treeNodeStack.isEmpty()) {
            node = treeNodeStack.pollLast();
            curSum = sumStack.pollLast();
            if (node.left == null && node.right == null && curSum == 0) {
                return true;
            }
            if (node.left != null) {
                treeNodeStack.add(node.left);
                sumStack.add(curSum - node.left.val);
            }
            if (node.right != null) {
                treeNodeStack.add(node.right);
                sumStack.add(curSum - node.right.val);
            }
        }
        return false;
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












