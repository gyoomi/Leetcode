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
 * @date 2019-11-05 9:06
 */
public class Solution02 {

    public boolean isPalindrome(ListNode head) {
        // 特殊情况：没有节点或1个节点都算作回文数
        if (head == null || head.next == null) {
            return true;
        }

        int len = 0;
        ListNode first = head;
        while (first != null) {
            len++;
            first = first.next;
        }

        // 翻转前半部分链表
        ListNode cur = head, pre = null;
        for (int i = 0; i < len / 2; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 奇数个链表结点cur后移一位
        if ((len % 2) != 0) {
            cur = cur.next;
        }

        // 遍历比较pre和cur的值相等否
        ListNode p = cur, q = pre;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
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
