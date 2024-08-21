package com.example.tree;

/**
 * <p>L96:不同的二叉搜索树</p>
 * <p>
 *     给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * </p>
 * @author zhenwu
 * @date 2024/8/21 21:10
 */
public class L96_NumTrees {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTrees(n));
    }

    private static int numTrees(int n) {
        // dp[i]:表示恰由 i 个节点成且节点值从 1 到 i 互不相同的二叉搜索树个数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int leftNum = dp[j - 1];
                int rightNum = dp[i - j];
                dp[i] += leftNum * rightNum;
            }
        }
        return dp[n];
    }
}
