/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.p206;


/**
 * 206. 反转链表
 *
 *      反转一个单链表。
 *
 *      示例:
 *      输入: 1->2->3->4->5->NULL
 *      输出: 5->4->3->2->1->NULL
 *
 *      进阶:
 *      你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 *      解释思路:
 *        在遍历列表时，将当前节点的 next 指针改为指向前一个元素。
 *        由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
 *        在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
 *
 *      复杂度分析:
 *        时间复杂度：O(n)，假设 n是列表的长度，时间复杂度是 O(n)。
 *        空间复杂度：O(1)。
 *
 * @author Leon
 * @version 2019/5/21 16:36
 */

class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Main {
}
