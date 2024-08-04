package com.example.dp;

import java.util.List;

/**
 * <p>L120:三角形最小路径和</p>
 * <p>给定一个三角形 triangle ，找出自顶向下的最小路径和。</p>
 * <p>每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。</p>
 */
public class L120_MinimumTotal {
    public static void main(String[] args) {

    }

    /**
     * dp[i][j]: 该点到达底层的最小路径和
     * 递推公式：dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]
     */
    private static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];

        // 自底向上开始递推
        for (int i = n - 1; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}