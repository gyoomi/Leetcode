package com.gyoomi.FindAllDuplicatesInanArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/8/22 21:08
 */
public class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    if (!ans.contains(nums[i])) {
                        ans.add(nums[i]);
                    }
                }
            }
        }
        return ans;
    }
}
