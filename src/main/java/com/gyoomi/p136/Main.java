package com.gyoomi.p136;

/**
 * 136. 只出现一次的数字
 *
 *      给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 *      说明：
 *      你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 *      示例 1:
 *      输入: [2,2,1]
 *      输出: 1
 *
 *      示例 2:
 *      输入: [4,1,2,1,2]
 *      输出: 4
 *
 *      思路一：先排序，再进行查找
 *      思路二：hashMap
 *      思路三：使用异或运算的特殊性（非常巧妙）
 *
 *
 * @author Leon
 * @version 2019/5/26 23:27
 */

class Solution {

    public int singleNumber(int[] nums) {
        //  插入排序
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            // 寻找arr[i]合适的插入位置
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j -1);
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < length - 1; i+=2) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            return nums[i];
        }
        return nums[length - 1];
    }

    private void swap(int[] arr, int l, int r) {
        if (l != r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        int[] arr = {4, 1, 2, 1, 2};
        new Solution().singleNumber(arr);
    }
}
