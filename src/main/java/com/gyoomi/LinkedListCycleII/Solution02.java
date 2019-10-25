/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.LinkedListCycleII;

/**
 * Linked List Cycle II
 *
 * @author Leon
 * @date 2019-10-25 9:52
 */
public class Solution02 {


    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;

        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;

            // 到达相遇点
            if (slow == fast) {
                meet = fast;
                while (head != meet) {
                    head = head.next;
                    meet = meet.next;
                }
                return head;
            }

        }
        return null;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
