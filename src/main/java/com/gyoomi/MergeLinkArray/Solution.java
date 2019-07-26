package com.gyoomi.MergeLinkArray;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/7/26 23:53
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            // l1.val > l2.val
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    class ListNode {
        int val;
        ListNode next;
    }
}
