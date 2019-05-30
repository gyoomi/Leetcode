package com.gyoomi.p094;

/**
 * 94. 二叉树的中序遍历
 *
 *     给定一个二叉树，返回它的中序遍历。
 *     示例:
 *     输入: [1,null,2,3]
 *     输出: [1,3,2]
 *
 *     进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *     思路一：递归版的二叉树中序遍历
 *             Solution#inorderTraversal(TreeNode root)
 *
 *
 *     思路二：非递归版的二叉树中序遍历
 *             基于栈结构的遍历
 *              1、从根节点开始一直往左走，将经过的所有节点压栈；
 *              2、栈不空则出栈，将出栈节点添加到list并且转向该节点的右子树；
 *              3、栈为空则重复执行上述两个步骤。
 *
 * @author Leon
 * @version 2019/5/30 22:41
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            if (cur != null && cur.left != null) {
                cur = cur.left;
                stack.push(cur);
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                if (cur != null && cur.right != null) {
                    cur = cur.right;
                    stack.push(cur);
                } else {
                    cur = null;
                }
            }
        }
        return result;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
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
