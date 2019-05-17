package com.gyoomi.p003;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 *
 * 示例 1:
 *      输入: "abcabcbb"
 *      输出: 3
 *      解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *      输入: "bbbbb"
 *      输出: 1
 *      解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *      "pwwkew"
 *      输出: 3
 *      解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *
 *
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author Leon
 * @version 2019/5/17 22:34
 */

class Solution {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }
}

class Solution1 {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int ans = 0;
        for (int i = ans; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String str, int start, int end) {
        Set<Character> sets = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (sets.contains(str.charAt(i))) {
                return false;
            }
            sets.add(str.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Solution1 solution = new Solution1();
        int i = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }
}

public class Main {

    public static void main(String[] args) {

    }
}
