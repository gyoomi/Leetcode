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











































