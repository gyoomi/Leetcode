/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-10-08 11:06
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(ans, root);
        return ans;
    }

    private void postOrder(List<Integer> ans, TreeNode root) {
        if (root != null) {
            postOrder(ans, root.left);
            postOrder(ans, root.right);
            ans.add(root.val);
        }
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
