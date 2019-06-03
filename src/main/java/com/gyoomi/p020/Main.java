/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.p020;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. 有效的括号
 *     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 *     有效字符串需满足：
 *      1. 左括号必须用相同类型的右括号闭合。
 *      2. 左括号必须以正确的顺序闭合。
 *     注意空字符串可被认为是有效字符串。
 *
 *     示例 1:
 *       输入: "()"
 *       输出: true
 *
 *     示例 2:
 *      输入: "()[]{}"
 *      输出: true
 *
 *     示例 3:
 *      输入: "(]"
 *      输出: false
 *
 *    示例 4:
 *
 *     输入: "([)]"
 *     输出: false
 *
 *
 *
 * @author Leon
 * @version 2019/6/3 16:16
 */

class Solution {

    private HashMap<Character, Character> mappings;

    public Solution() {
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 闭括号的情况
            if (this.mappings.containsKey(c)) {
                char topEle = stack.empty() ? '#': stack.pop();
                if (topEle != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // 开括号，加入到栈中去
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}

public class Main {

    public static void main(String[] args) throws Exception {

    }
}
















