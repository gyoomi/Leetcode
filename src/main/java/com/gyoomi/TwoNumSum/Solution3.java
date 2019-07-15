package com.gyoomi.TwoNumSum;
import java.util.HashMap;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/7/15 14:34
 */
public class Solution3 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && i != map.get(complement)) {
                return new int [] {i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
