package com.gyoomi.p015;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 15. 三数之和
 *
 *     给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 *     注意：答案中不可以包含重复的三元组。
 *
 *     例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *     满足要求的三元组集合为：
 *     [
 *      [-1, 0, 1],
 *      [-1, -1, 2]
 *     ]
 *
 *     思路：
 *     首先对数组从小到大排序，从一个数开始遍历，若该数大于0，后面的数不可能与其相加和为0，所以跳过；否则该数可能是满足要求的第一个数，
 *     这样可以转化为求后面数组中两数之和为该数的相反数的问题。定义两个指针一前一后，若找到两数之和满足条件则加入到解集中；
 *     若大于和则后指针向前移动，反之则前指针向后移动，直到前指针大于等于后指针。这样遍历第一个数直到数组的倒数第3位。
 *     注意再求和过程中首先判断该数字是否与前面数字重复，保证解集中没有重复解。
 *
 * @author Leon
 * @version 2019/5/18 17:55
 */

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Stack<Stack<Integer>> res = new Stack<>();
        Stack<Integer> v = new Stack<>();
        int length = nums.length;
        int sum = -1;

        if (length < 3) {
            List<List<Integer>> resultToUse = new ArrayList<>();
            return resultToUse;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] <= 0) {
                v.push(nums[i]);

                if (sum == 0 - nums[i]) {
                    v.pop();
                    continue;
                }

                sum = 0 - nums[i];
                int l = i + 1, r = length - 1;
                int di = nums[l] - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        if (di != nums[l]) {
                            v.push(nums[l]);
                            v.push(nums[r]);
                            res.push((Stack)v.clone());
                            v.pop();
                            v.pop();
                            di = nums[l];
                        }
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        l++;
                    } else if (nums[l] + nums[r] > sum) {
                        r--;
                    }
                }
                v.pop();
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Stack<Integer> re : res) {
            List<Integer> l = new ArrayList<>();
            for (Integer integer : re) {
                l.add(integer);
            }
            result.add(l);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new Solution().threeSum(arr);
        System.out.println(lists);
    }
}

class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return ls;
    }
}

public class Main {
}
