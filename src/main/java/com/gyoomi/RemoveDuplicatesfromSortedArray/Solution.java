/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.RemoveDuplicatesfromSortedArray;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-10-12 8:49
 */
public class Solution {
    /**
     *
     * []
     *
     * [1]
     *
     * [1, 2] => [2, 2]
     *
     * [1, 1]
     *
     * [1, 1, 2] => [1, 1, 2] => [1, 2, 2]
     * [1, 2, 3] => [2, 2, 3] => [2, 3, 3]
     * [1, 2, 3, 3] => [2, 2, 3, 3] => [2, 3, 3, 3]
     * [1, 2, 3, 4] => [2, 2, 3, 4] => [2, 3, 3, 4] => [2, 3, 4, 4]
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
