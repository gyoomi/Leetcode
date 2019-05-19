package com.gyoomi.p217;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 217. 存在重复元素
 *      给定一个整数数组，判断是否存在重复元素。
 *      如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 *      示例 1:
 *      输入: [1,2,3,1]
 *      输出: true
 *
 *      示例 2:
 *      输入: [1,2,3,4]
 *      输出: false
 *
 *      示例 3:
 *      输入: [1,1,1,3,3,4,3,2,4,2]
 *      输出: true
 *
 *      方法一：暴力穷举
 *      最差时间复杂度 O(n^2)
 *      最差空间复杂度 O(1)
 *
 *      方法二：先排序，再把相邻的元素两两比较
 *      最差时间复杂度 O(n)
 *      最差空间复杂度 O(1)
 *
 *
 * @author Leon
 * @version 2019/5/19 23:02
 */

class Solution3 {

    /**
     * 方法二
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i <= length - 2 && nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

}

class Solution2 {

    /**
     * 方法一的升级写法
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(x -> x, x -> 1, Integer::sum))
                .values()
                .stream()
                .anyMatch(t -> t >1);
    }

}

class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
public class Main {

    public static void main(String[] args) throws Exception {
        Solution2 solution2 = new Solution2();
        int[] arr = {1, 2, 3, 4, 1, 2};
        solution2.containsDuplicate(arr);
    }
}
