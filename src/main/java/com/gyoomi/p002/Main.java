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
 *    解题思路：
 *
 *    我们使用变量来跟踪进位，并从包含最低有效位的表头开始模拟逐位相加的过程。
 *
 *    就像你在纸上计算两个数字的和那样，我们首先从最低有效位也就是列表 l1l1 和 l2l2 的表头开始相加。
 *    由于每位数字都应当处于 0 \ldots 90…9 的范围内，我们计算两个数字的和时可能会出现 “溢出”。
 *    例如，5 + 7 = 125+7=12。在这种情况下，我们会将当前位的数值设置为 22，并将进位 carry = 1carry=1 带入下一次迭代。
 *    进位 carrycarry 必定是 00 或 11，这是因为两个数字相加（考虑到进位）可能出现的最大和为 9 + 9 + 1 = 199+9+1=19。
 *
 *    伪代码如下：
 *    1. 将当前结点初始化为返回列表的哑结点。
 *    2. 将进位 carrycarry 初始化为 00。
 *    3. 将 pp 和 qq 分别初始化为列表 l1l1 和 l2l2 的头部。
 *    4. 遍历列表 l1l1 和 l2l2 直至到达它们的尾端。
 *        将 xx 设为结点 pp 的值。如果 pp 已经到达 l1l1 的末尾，则将其值设置为 00。
 *        将 yy 设为结点 qq 的值。如果 qq 已经到达 l2l2 的末尾，则将其值设置为 00。
 *       设定 sum = x + y + carrysum=x+y+carry。
 *       更新进位的值，carry = sum / 10carry=sum/10。
 *       创建一个数值为 (sum \bmod 10)(summod10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
 *       同时，将 pp 和 qq 前进到下一个结点。
 *    5. 检查 carry = 1carry=1 是否成立，如果成立，则向返回列表追加一个含有数字 11 的新结点。
 *    6. 返回哑结点的下一个结点。
 *
 *    请注意，我们使用哑结点来简化代码。如果没有哑结点，则必须编写额外的条件语句来初始化表头的值。
 *
 *
 *    复杂度分析:
 *
 *    时间复杂度：O(max(m, n))O(max(m,n))，假设 mm 和 nn 分别表示 l1l1 和 l2l2 的长度，上面的算法最多重复 max(m, n)max(m,n) 次。
 *    空间复杂度：O(max(m, n))O(max(m,n))， 新列表的长度最多为 max(m,n) + max(m,n)+1。
 *
 * @author Leon
 * @version 2019/5/20 15:31
 */


class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

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
        // 翻转后，进行数字相加
        // 利用BigInteger解决超大整形数溢出问题
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
