/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.SameTree;

import java.util.ArrayDeque;

/**
 * Same tree
 *
 * @author Leon
 * @date 2019-09-25 13:53
 */
public class Solution02 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) {
            return true;
        }
        if (!check(p, q)) {
            return false;
        }

        // init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<>();

        deqP.addLast(p);
        deqQ.addLast(q);
        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();
            if (!check(p, q)) {
                return false;
            }
            if (p != null) {
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left)) {
                    return false;
                }
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right)) {
                    return false;
                }
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }

        return true;
    }

    public boolean check(TreeNode p, TreeNode q) {
        // Both of them are null
        if (p == null && q == null) {
            return true;
        }
        // One of p and q is null
        if (p == null || q == null) {
            return false;
        }
        // Equal
        if (p.val != q.val) {
            return false;
        }
        return true;
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
