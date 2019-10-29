/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.ReverseString;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-10-29 9:01
 */
public class Solution {

    public void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
