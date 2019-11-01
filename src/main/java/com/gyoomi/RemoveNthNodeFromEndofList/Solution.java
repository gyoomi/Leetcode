/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.RemoveNthNodeFromEndofList;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-11-01 9:09
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }

        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
