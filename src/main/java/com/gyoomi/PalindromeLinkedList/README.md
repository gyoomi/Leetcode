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







































