## 78. 子集

给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例：

```java
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

代码

```java
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {

            ListIterator<List<Integer>> listListIterator = result.listIterator();

            while (listListIterator.hasNext()) {
                List<Integer> list = listListIterator.next();
                List<Integer> tempList = new ArrayList<>(list);
                tempList.add(num);
                listListIterator.add(tempList);
            }
        }
        return result;
    }
}
```


































