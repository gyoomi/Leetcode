/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.LengthofLastWord;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-10-16 8:58
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }

        String[] words = s.split(" +");
        return words[words.length - 1].length();
    }

}
