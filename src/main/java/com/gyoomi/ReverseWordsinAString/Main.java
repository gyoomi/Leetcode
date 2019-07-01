/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.ReverseWordsinAString;

/**
 * 151. 翻转字符串里的单词
 *      给定一个字符串，逐个翻转字符串中的每个单词。
 *      示例 1：
 *        输入: "the sky is blue"
 *        输出: "blue is sky the"
 *      示例 2：
 *        输入: "a good   example"
 *        输出: "example good a"
 *       解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *      说明：
 *      无空格字符构成一个单词。
 *      输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *      如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * @author Leon
 * @version 2019/7/1 13:48
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String s = " hello world! ";
        String s1 = new Solution().reverseWords(s);
    }
}



class Solution {

    public String reverseWords(String s) {
        String[] split = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            String curStr = split[i];
            sb.append(curStr);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}















