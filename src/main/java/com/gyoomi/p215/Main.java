/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.p215;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 *      在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *      示例 1:
 *      输入: [3,2,1,5,6,4] 和 k = 2
 *      输出: 5
 *
 *      示例 2:
 *      输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 *      输出: 4
 *
 *      说明: 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 *      思路一：排序后进行取
 *      思路二：使用最小堆进行相关实现
 *
 *
 *
 *
 * @author Leon
 * @version 2019/5/24 17:01
 */

class Solution {

    public int findKthLargest(int[] nums, int k) {
        // 使用插入排序算法进行排序，按照从大到小进行排序
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            // 此次待插入的数组中数据
            int curInsert = nums[i];
            int j = i - 1;
            while (j >= 0 && curInsert > nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = curInsert;
        }
        return nums[k - 1];
    }
}

class Solution1 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}


public class Main {

    public static void main(String[] args) throws Exception {
        int[] arr = {-9, 12, 8, 55, 84, -90, 25, 28, 25, 3};
        new Solution().findKthLargest(arr, 1);

    }

}























