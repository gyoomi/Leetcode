/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.LinkedListCycleII;

import java.util.HashSet;

/**
 * Linked List Cycle II
 *
 * @author Leon
 * @date 2019-10-24 14:53
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();

        while (head != null) {
            // 有环链表的退出节点
            if (visited.contains(head)) {
                return head;
            }

            visited.add(head);
            head = head.next;
        }
        // 代码走在这里，代表链表没有环
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
