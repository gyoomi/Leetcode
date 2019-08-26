## 169. 求众数

给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

```
输入: [3,2,3]
输出: 3
```

示例 2:

```
输入: [2,2,1,1,1,2,2]
输出: 2
```

思路1：hash暴力破解法

```java
public class Solution {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k, v) -> {
                if (map.containsKey(num)) {
                    return v + 1;
                } else {
                    return 1;
                }
            });
        }

        int ans = -1;
        int times = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > times) {
                times = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
```

思路2：暴力

**想法**

我们可以在平方级的时间里穷举所有情况，来检测每个数是不是众数。

**算法**

暴力算法遍历整个数组，然后用另一重循环统计每个数字出现的次数。将出现次数比其他数字加起来出现次数还多的元素返回。

**代码**

```java
public class Solution2 {

    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int ele : nums) {
                if (num == ele) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }
        }
        return -1;
    }
}
```

**复杂度分析**

- 时间复杂度：O(n^2)   暴力算法包含两重嵌套的 for 循环，每一层 nn 次迭代，所以总的是平方级的时间复杂度。
- 空间复杂度：O(1)     暴力方法没有分配任何与输入规模成比例的额外的空间
   
方法3：摩尔投票算法

思路：

其核心思想就是：抵消

最差的情况就是其他所有的数都跟众数做了抵消，但是由于众数出现的次数大于1/2，所以最终剩下的还是众数。

```java

public class Solution3 {

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
```