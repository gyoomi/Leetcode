## 442. 数组中重复的数据

给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

找到所有出现两次的元素。

你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

示例：

输入:
```java
[4,3,2,7,8,2,3,1]
```


输出:

```java

[2,3]
```

思路1：

```java

public class Solution {
    // the way of original 
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    if (!ans.contains(nums[i])) {
                        ans.add(nums[i]);
                    }
                }
            }
        }
        return ans;
    }
}
```

思路2：元素变成索引

这个题目开头暗示了n的范围，所以可以加以利用，将元素转换成数组的索引并对应的将该处的元素乘以-1；
若数组索引对应元素的位置本身就是负数，则表示已经对应过一次；在结果列表里增加该索引的正数就行；

```java
public class Solution2 {

    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] > 0) {
                nums[Math.abs(num) - 1] *= -1;
            } else {
                ans.add(Math.abs(num));
            }
        }
        return ans;
    }
}
```