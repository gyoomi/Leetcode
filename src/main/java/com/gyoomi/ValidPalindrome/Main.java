/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.ValidPalindrome;

/**
 * 125. 验证回文串
 *      给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *      说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *      示例1：
 *      输入: "A man, a plan, a canal: Panama"
 *      输出: true
 *
 *      示例2：
 *      输入: "race a car"
 *      输出: false
 *
 *      方法1：暴力破解法
 *      方法2：双指针法
 *
 *
 *
 *
 * @author Leon
 * @version 2019/7/3 9:21
 */
public class Main {

    public static void main(String[] args) throws Exception {

    }

}

class Solution {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90)) {
                sb.append(c);
            }
        }
        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
        return s1.equals(s2);
    }
}

















