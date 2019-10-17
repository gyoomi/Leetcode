## 109. 有序链表转换二叉搜索树

给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例：

```text
给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

```

**方法1： 链表转数组，使用数组的二分 + 递归进行处理**

**代码实现**

```java
public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return convertListToTree(list, 0, list.size());
    }

    private TreeNode convertListToTree(List<Integer> list, int l, int r) {
        if (l >= r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = convertListToTree(list, l, mid);
        root.right = convertListToTree(list, mid + 1, r);
        return root;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
```

**方法2：快慢指针**

**思路**

有没有一种方案，不用数组的辅助呢？那么我们需要解决怎么得到 mid 的值的问题？

最直接的思路就是根据 start 和 end，求出 mid，然后从 head 遍历 mid - start 次，就到达了 mid 值。但最开始的 end，我们还得遍历一遍链表才能得到，总体来说就是太复杂了。

这里有一个求中点节点值的技巧，利用快慢指针。

快指针和慢指针同时从头部开始遍历，快指针每次走两步，慢指针每次走一步，当快指针走到链表尾部，此时慢指针就指向了中间位置。

除了求中点节点的值不一样，基本架构和 `方法1` 是一样的。

**代码实现**

```java
public class Solution02 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, tail);
        return root;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
```

**时间复杂度**
- 时间复杂度：根据递归式可知，`T(n) = 2 * T（n / 2 ) + n`， `O(nlog(n))`。
- 空间复杂度：`O(log(n))`。











































