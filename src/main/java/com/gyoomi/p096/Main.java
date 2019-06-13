/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.p096;

import java.util.ArrayList;
import java.util.List;

/**
 * 96. 不同的二叉搜索树
 *     给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *     示例:
 *         输入: 3
 *         输出: 5
 *         解释:
 *         给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *     思路:
 *         标签：动态规划
 *         假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数，则
 *         G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
 *
 *         当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，(即以i为根结点的二叉树数量等于其左子树个数乘右子树个数)。则
 *         f(i)=G(i−1)∗G(n−i)
 *
 *         综合两个公式可以得到 卡特兰数 公式
 *         G(n)= G(1)G(n-1) + G(2)G(n-2) ……+ G(n-1)G(1)
 *
 * @author Leon
 * @version 2019/6/13 13:50
 */
class Solution2 {

    /**
     * 递归版实现
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numTrees(i) * numTrees(n - 1 - i);
        }
        return sum;
    }
}

class Solution {

    /**
     * 迭代版
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public int numTrees2(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0;j < i; j++) {
                sum += list.get(j) * list.get(i-1-j);
            }
            list.add(sum);
        }
        return list.get(n);
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(new Solution2().numTrees(3));
    }
}
