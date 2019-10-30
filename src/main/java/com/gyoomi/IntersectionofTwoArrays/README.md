## 349. 两个数组的交集 Intersection of Two Arrays

给定两个数组，编写一个函数来计算它们的交集。

示例 1:

```text
输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]
```

示例 2:

```text
输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]
```

**说明**
- 输出结果中的每个元素一定是唯一的。
- 我们可以不考虑输出结果的顺序。

**方法1：Set方法**

**实现代码**

```java
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result.add(nums1[i]);
                    break;
                }
            }
        }

        // set转int[]
        int[] ans = new int[result.size()];
        int i = 0;
        for (Integer integer : result) {
            ans[i++] = integer;
        }
        return ans;
    }
}
```





















































