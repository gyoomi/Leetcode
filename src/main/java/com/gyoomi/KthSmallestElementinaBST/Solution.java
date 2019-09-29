/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.KthSmallestElementinaBST;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-09-29 14:59
 */
public class Solution {

    private int res = -1;

    private int count;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        // 递归出口：递归到底或者已经找到第K小的元素（根据count来判断）
        if (root == null || count == 0) {
            return;
        }
        inOrder(root.left);
        if (--count == 0) {
            res = root.val;
        }
        inOrder(root.right);
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
