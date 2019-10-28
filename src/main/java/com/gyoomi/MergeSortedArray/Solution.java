/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.MergeSortedArray;

import java.util.Arrays;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-10-28 10:13
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
