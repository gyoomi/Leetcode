/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.IntersectionofTwoArrays;

import java.util.HashSet;
import java.util.Set;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-10-30 8:55
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result.add(nums1[i]);
                    break;
                }
            }
        }

        // set转int[]
//        int[] ans = new int[result.size()];
//        int i = 0;
//        for (Integer integer : result) {
//            ans[i++] = integer;
//        }
//        return ans;
        return result.parallelStream().mapToInt(Integer::intValue).toArray();
    }
}
