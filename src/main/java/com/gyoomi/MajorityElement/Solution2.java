package com.gyoomi.MajorityElement;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/8/25 23:12
 */
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
