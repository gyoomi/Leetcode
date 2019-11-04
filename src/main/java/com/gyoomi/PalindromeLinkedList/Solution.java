/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.PalindromeLinkedList;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-11-04 16:06
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        int len = 0;
        ListNode first = head;
        while (first != null) {
            len++;
            first = first.next;
        }

        int[] dest = new int[len];
        for (int i = 0; i < len; i++) {
            if (head != null) {
                dest[i] = head.val;
                head = head.next;
            }
        }

        int i = 0, j = len - 1;
        while (i < len || j >= 0) {
            if (dest[i] != dest[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
