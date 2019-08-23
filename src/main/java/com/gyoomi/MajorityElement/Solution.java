package com.gyoomi.MajorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/8/23 23:20
 */
public class Solution {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k, v) -> {
                if (map.containsKey(num)) {
                    return v + 1;
                } else {
                    return 1;
                }
            });
        }

        int ans = -1;
        int times = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > times) {
                times = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
