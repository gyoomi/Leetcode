/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.p002;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 2. 两数相加
 *    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 *    并且它们的每个节点只能存储 一位 数字。
 *
 *    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 *    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *    示例：
 *    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *    输出：7 -> 0 -> 8
 *    原因：342 + 465 = 807
 *
 *
 *
 * @author Leon
 * @version 2019/5/20 15:31
 */
/**
 * 我的
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode t1 = l1;
        ListNode t2 = l2;
        StringBuilder sb1 = new StringBuilder();
        while (t1 != null) {
            sb1.append(t1.val);
            t1 = t1.next;
        }

        StringBuilder sb2 = new StringBuilder();
        while (t2 != null) {
            sb2.append(t2.val);
            t2 = t2.next;
        }
        BigInteger sum = new BigInteger(sb1.reverse().toString()).add(new BigInteger(sb2.reverse().toString()));

        String sumToUse = sum.toString();
        int n = sumToUse.length() - 1;
        while (n >= 0) {
            temp.next = new ListNode(Integer.parseInt(String.valueOf(sumToUse.charAt(n--))));
            temp = temp.next;
        }

        return result.next;
    }
}

class ListNode implements Serializable {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = new Solution().addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
