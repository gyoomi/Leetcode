/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.SameTree;

/**
 * Same tree
 *
 * @author Leon
 * @date 2019-09-25 13:53
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) {
            return true;
        }
        // one of p and q is null
        if (p == null | q == null) {
            return false;
        }
        // compare p and q value
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {

    }


}
