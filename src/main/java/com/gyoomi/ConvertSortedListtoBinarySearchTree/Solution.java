/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.ConvertSortedListtoBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-10-17 9:09
 */
public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return convertListToTree(list, 0, list.size());
    }

    private TreeNode convertListToTree(List<Integer> list, int l, int r) {
        if (l >= r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = convertListToTree(list, l, mid);
        root.right = convertListToTree(list, mid + 1, r);
        return root;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
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
