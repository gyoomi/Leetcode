/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.ConvertSortedArraytoBinarySearchTree;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-10-16 9:13
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return convertToTree(nums, 0, nums.length);
    }

    private TreeNode convertToTree(int[] nums, int left, int right) {
        // 定义的二分区间为[left, right]，无法进行继续递归，直接退出
        if (left >= right) {
            return null;
        }
        // 这样写内存不够
        // int mid = (right + (left - right)) / 2;
        // int mid = (left + (right - left)) >> 1;

        // 这样写有风险
        int mid = (right + left) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convertToTree(nums, left, mid);
        root.right = convertToTree(nums, mid + 1, right);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
