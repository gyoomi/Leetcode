# 16. 最接近的三数之和


给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

>例如，给定数组 `nums = [-1，2，1，-4]`, 和 `target = 1`.
>
>与 `target` 最接近的三个数的和为 2. `(-1 + 2 + 1 = 2)`.

**解法1： 双指针**

思路

- 先让数组有序，也就是需要先对数组进行排序
- 之后每次固定一个元素，再去寻找另外两个元素(也就是双指针)

代码思路

- 利用 `Arrays.sort(nums)` 对数组进行排序。
- 初始化一个用于保存结果的值 `result = nusm[0] + nums[1] + nums[2]` （不要自己设初值，直接从数组中抽取三个元素，假设这是最接近的三数之和，然后再更新就是了）。利用下标 `i` 对数组进行遍历，此时就是在固定第一个元素，注意，下标 `i` 的边界为 `i < nums.length-2`，否则设置指针的时候会出现数组越界。
- 每次遍历的过程中设置两个指针，分别是 `left = i + 1`、`right = nums.length - 1`。
- 检查 `sum = nums[i] + nums[left] + nums[right]`与 `target` 的距离，如果该距离比之前保存的 `result` 与 `target` 的距离更小，就更新 `result`。
- 然后就是移动双指针。
- 如果 `sum` 的值比 `target` 大，那么我们让 `right--`，因为数组是有序的，`right--`会使得下一次的 `sum` 更小，也就更接近 `target` 的值
- 同理，如果 `sum` 的值 `target` 小，那么我们让 `left++`·
- `left++` 和 `right--` 的界限自然是 `left != right`，如果 `left == right`，说明我们已经将所有的元素都遍历过一遍了。
- 重复上面的操作，直到i循环结束为止，返回 `result`


```java
public class Solution {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		// 初始化值
		int result = nums[0] + nums[1] + nums[2];

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left != right) {
				int sum = nums[i] + nums[left] + nums[result];
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
				if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return result;
	}
}
```

**解法2：双指针法的优化**

TODO






























