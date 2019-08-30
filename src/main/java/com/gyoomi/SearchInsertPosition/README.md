## 35. 搜索插入位置

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

```java
输入: [1,3,5,6], 5
输出: 2
```

示例 2:

```java
输入: [1,3,5,6], 7
输出: 4
```

方法1：二分查找

**思路**

整体思路和普通的二分查找几乎没有区别，先设定左侧下标 `left` 和右侧下标 `right`，再计算中间下标 `mid`。

每次根据 `nums[mid]` 和 `target` 之间的大小进行判断，相等则直接返回下标，`nums[mid] < target` 则 `left `右移，`nums[mid] > target` 则 `right` 左移

查找结束如果没有相等值则返回 `left`，该值为插入位置。

**代码**

```java
public class Solution {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // int mid = (left + right) / 2;
            // 有可能整型溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
```

**时间复杂度**

O(logn)