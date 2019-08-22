package com.gyoomi.FindAllDuplicatesInanArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/8/22 21:08
 */
public class Solution2 {

    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] > 0) {
                nums[Math.abs(num) - 1] *= -1;
            } else {
                ans.add(Math.abs(num));
            }
        }
        return ans;
    }
}
