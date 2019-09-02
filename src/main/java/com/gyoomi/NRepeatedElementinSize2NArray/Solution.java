/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.NRepeatedElementinSize2NArray;

import java.util.HashMap;
import java.util.Map;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/9/2 14:26
 */
public class Solution {

    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.compute(A[i], (k, v) -> {
                if (v == null) {
                    v = 1;
                } else {
                    v = v + 1;
                }
                return v;
            });
        }
        int ans = -1;
        int ansVal = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 重复了N次。总长度是2N。
            if (entry.getValue() >= A.length / 2 && entry.getValue() > ansVal) {
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
