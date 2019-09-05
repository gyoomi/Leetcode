/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.BinaryTreePaths;

import java.util.LinkedList;
import java.util.List;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/9/5 10:56
 */
public class Solution {

    public void constructPaths(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            // 当前节点是叶子节点 -> 递归出口
            if (root.left == null && root.right == null) {
                paths.add(path);
            } else {
                // 当前节点不是叶子节点，继续递归遍历
                path += "->";
                constructPaths(root.left, path, paths);
                constructPaths(root.right, path, paths);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        constructPaths(root, "", paths);
        return paths;
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
