/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.ThreeSumClosest;

import java.util.Arrays;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-11-28 14:34
 */
public class Solution {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[2];

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left != right) {
				int sum = nums[i] + nums[left] + nums[result];
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
				if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return result;
	}
}
