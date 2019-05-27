package com.gyoomi.p136;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
 *      思路二：hashMap Time: O(n) Space: O(n)
 *      思路三：使用异或运算的特殊性（非常巧妙）
 *          与运算（&） 两位同时为“1”，结果才为“1”，否则为0
 *          或运算（|） 参加运算的两个对象只要有一个为1，其值为1
 *          异或运算（^） 同为0，异为1.  任何整数^0 不变
 *
 * @author Leon
 * @version 2019/5/26 23:27
 */

class Solution2 {

    /**
     * 由于 0^a = a，a^a = 0 而数组中除了一个数字是只出现一次的，其他数字均出现两次.
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int cal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cal = cal ^ nums[i];
        }
        return cal;
    }
}

class Solution1 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            count = count == null ? 1 : ++count;
            map.put(nums[i], count);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (1 == entry.getValue()) {
                return entry.getKey();
            }
        }

        // Can't find then return -1
        return -1;
    }
}

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
        System.out.println(8 ^ 5 ^ 10 ^ 5 ^ 8);
    }
}








