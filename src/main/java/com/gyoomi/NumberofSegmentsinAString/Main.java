/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.NumberofSegmentsinAString;

/**
 * 434. 字符串中的单词数
 *      统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *      请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 *      1. 利用系统api实现
 *      2. 自己实现
 *
 *
 * @author Leon
 * @version 2019/6/28 15:37
 */
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("".length());
    }
}

class Solution2 {

    /**
     * 每次出现非空字符，看看上一个是不是空格，如果是，发现一个新单词
     *
     * @param s
     * @return
     */
    public int countSegments(String s) {
        int count = 0;
        boolean lastIsBlank = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                lastIsBlank = true;
            } else {
                if (lastIsBlank) {
                    count++;
                }
                lastIsBlank = false;
            }
        }
        return count;
    }
}

class Solution {

    public int countSegments(String s) {
        s = s.trim();
        if (null == s || s.length() <= 0) {
            return 0;
        }
        String[] split = s.split(" +");
        return split.length;
    }
}
