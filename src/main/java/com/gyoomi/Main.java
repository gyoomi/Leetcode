package com.gyoomi;

import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/6/9 23:18
 */
public class Main {

    public static void main(String[] args) {
        String str = "hello java, i am vary happy! nice to meet you";

        // jdk1.8之前的写法
        HashMap<Character, Integer> result1 = new HashMap<>(32);
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            Integer curVal = result1.get(curChar);
            if (curVal == null) {
                curVal = 1;
            } else {
                curVal += 1;
            }
            result1.put(curChar, curVal);
        }

        // jdk1.8的写法
        HashMap<Character, Integer> result2 = new HashMap<>(32);
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            result2.compute(curChar, (k, v) -> {
                if (v == null) {
                    v = 1;
                } else {
                    v += 1;
                }
                return v;
            });
        }

        System.out.println(result1);
        System.out.println(result2);

        // 求一个数的平方
        Function<Integer, Integer> fun1= arg -> arg * arg;
        Integer apply = fun1.apply(10);
        // 100
        System.out.println(apply);

        // 求输入两个的和
        BiFunction<Integer, Integer, Integer> fun2 = (arg1, arg2) -> arg1 + arg2;
        Integer sum = fun2.apply(10, 20);
        // 30
        System.out.println(sum);
    }
}
