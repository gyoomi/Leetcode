package com.gyoomi.p102;

/**
 * 102. 二叉树的层次遍历
 *
 *      给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *      例如:
 *          给定二叉树: [3,9,20,null,null,15,7],
 *          [
 *             [3],
 *             [9,20],
 *             [15,7]
 *          ]
 *
 *
 *
 * @author Leon
 * @version 2019/6/1 21:25
 */

import java.util.*;

class Solution {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 核心在于,利用队列FIFO的特性来实现 层序遍历（广度优先遍历）
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> list = new ArrayList<>();
            while (curSize > 0) {
                TreeNode cur = queue.remove();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                curSize--;
            }
            result.add(list);
        }

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {

    public static void main(String[] args) throws Exception {

    }
}
