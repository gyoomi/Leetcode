package com.gyoomi.PlusOne;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/10/14 20:49
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            // 一般情况：没有出现进位的情况，加1后，退出。
            // 等价于 digits[i] >= 10
            if (digits[i] != 0) {
                return digits;
            }
        }

        // 特殊情况： 9999
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
