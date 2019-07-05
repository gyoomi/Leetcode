/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.ReverseOnlyLetters;

/**
 * 917. 仅仅反转字母
 *      给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *      示例1：
 *      输入："ab-cd"
 *      输出："dc-ba"
 *      提示：
 *      1. S.length <= 100
 *      2. 33 <= S[i].ASCIIcode <= 122
 *      3. S 中不包含 \ or "
 *
 *      方法1：
 *           先把字符串的字母进行倒序提取出来；然后在正向循环将非字母的字符插入对应位置的逆序字母的字符串中去。
 *      方法2：
 *           双指针
 *
 * @author Leon
 * @version 2019/7/4 9:49
 */
public class Main {

    public static void main(String[] args) throws Exception {

    }

}



class Solution {

    public String reverseOnlyLetters(String s) {
        StringBuilder reverseStr = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isLetter(s.charAt(i))) {
                reverseStr.append(s.charAt(i));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))) {
                reverseStr.insert(i, s.charAt(i));
            }
        }
        return reverseStr.toString();
    }
}

class Solution2 {

    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        // 左，右指针
        int l = 0, r = chars.length - 1;
        while (l < r) {
            while (l < r && !Character.isLetter(chars[l])) {
                l++;
            }
            while (l < r && !Character.isLetter(chars[r])) {
                r--;
            }
            swap(chars, l, r);
            l++;
            r--;
        }
        return String.valueOf(chars);
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}








