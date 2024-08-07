package com.example.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>L279:完全平方数</p>
 * <p>给你一个整数 n ，返回 和为 n 的完全平方数的最少数量.</p>
 */
public class L279_NumSquares {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(numSquares(n));
        System.out.println(numSquaresPro(n));
    }

    /**
     * dp[i][j]:使用完全平方数组成的数组 [1, 4, 9, ……] 可以 恰好凑成 和为 j 使用的完全平方数的个数的最小值
     */
    private static int numSquaresPro(int n) {
        int up = (int) Math.sqrt(n);

        // 初始化dp
        int[][] dp = new int[up + 1][n + 1];
        for (int i = 0; i <= up; i++) {
            Arrays.fill(dp[i], n + 1);
        }
        dp[0][0] = 0;

        // 开始递推
        for (int i = 1; i <= up; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= i * i && dp[i][j - i * i] != n + 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - i * i] + 1);
                }
            }
        }
        return dp[up][n];
    }

    private static int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while (i * i < n) {
            list.add(i * i);
            i++;
        }
        if (i * i == n) {
            return 1;
        }
        Integer[] nums = list.toArray(new Integer[0]);

        // dp[i]表示i分解成完全平方数之后所需完全平方数的最少数量
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int j = 1; j <= n; j++) {
            for (int num : nums) {
                if (num <= j && dp[j - num] != n + 1) {
                    dp[j] = Math.min(dp[j], dp[j - num] + 1);
                }
            }
        }
        return dp[n];
    }
}
