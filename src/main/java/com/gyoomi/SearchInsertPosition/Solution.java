package com.gyoomi.SearchInsertPosition;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/8/26 22:31
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // int mid = (left + right) / 2;
            // 有可能整型溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
