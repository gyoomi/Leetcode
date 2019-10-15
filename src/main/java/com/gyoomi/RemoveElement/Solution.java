/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.RemoveElement;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-10-15 9:38
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        // 两种情况：
        //  1. 当前快指针的对应的索引的值和指定的val相等 ==> 快指针+1，进入下一个迭代。慢指针不变。
        //  2. 当前快指针的对应的索引的值和指定的val不相等  ==> 将当前快指针的的值，拷贝到慢指针的位置。然后快慢指针同时加1
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
