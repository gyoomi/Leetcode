## 234. 回文链表

请判断一个链表是否为回文链表。

示例 1:

```text
输入: 1->2
输出: false
```

示例 2:

```text
输入: 1->2->2->1
输出: true
```

进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

方法1：数组暴力破解法

将链表的元素放入到数组中，然后双向循环数组进行判断。

```java
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
```

**方法2：快慢指针**

**思路**

1.关注代码的完整性、规范性、鲁棒性。

2.大致思路是反转前一半链表结点,分别和后面的链表结点值一一进行比较;

3.求出链表长度len,反转前半段链表,此时pre指向反转链表的头结点,也就是原链表的中间结点,cur指向后半段链表的第一个节点,如果len为奇数个,那么后半段链表的第一个节点是中间节点,需要将cur后移一位,最后遍历pre和cur比较值即可;



**代码实现**

```java
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

```


**时间复杂度**

- 第一个循环O(n/2)，第2个循环O(n/2)






























