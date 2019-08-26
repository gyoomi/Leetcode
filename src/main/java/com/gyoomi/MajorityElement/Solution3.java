package com.gyoomi.MajorityElement;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/8/26 22:18
 */
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
