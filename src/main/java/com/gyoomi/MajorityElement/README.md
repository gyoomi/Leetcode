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

思路1：map暴力破解法

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

