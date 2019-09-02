## 961. 重复 N 次的元素

在大小为 `2N` 的数组 A 中有 `N+1` 个不同的元素，其中有一个元素重复了 `N` 次。

返回重复了 `N` 次的那个元素。

示例 1：
```java
输入：[1,2,3,3]
输出：3
```

示例 2：
```java
输入：[2,1,2,5,3,2]
输出：2
```

提示：
```java
1. 4 <= A.length <= 10000
2. 0 <= A[i] < 10000
3. A.length 为偶数
```

方法一：Hash表暴力破解方

代码

```java
public class Solution {

    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.compute(A[i], (k, v) -> {
                if (v == null) {
                    v = 1;
                } else {
                    v = v + 1;
                }
                return v;
            });
        }
        int ans = -1;
        int ansVal = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 重复了N次。总长度是2N。
            if (entry.getValue() >= A.length / 2 && entry.getValue() > ansVal) {
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
```


























