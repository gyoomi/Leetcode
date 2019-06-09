package com.gyoomi.p387;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 *
 *      给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *      案例:
 *          s = "leetcode"
 *          返回 0.
 *
 *          s = "loveleetcode",
 *          返回 2.
 *
 *      方式一：暴力破解法（使用linkedHashMap）
 *      方法二：两次遍历字符串求得唯一字符
 *              第一次遍历字符串求得各字符出现次数. 第二次遍历字符串找出第一个出现次数为1的字符. 代码如下
 *
 *
 * @author Leon
 * @version 2019/6/9 21:57
 */

class Solution2 {

    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

class Solution {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.compute(c, (key, value) -> {
                if (value == null) {
                    value = 1;
                } else {
                    value += 1;
                }
                return value;
            });
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        int leetcode = new Solution().firstUniqChar("leetcode");
        System.out.println(leetcode);
    }
}
