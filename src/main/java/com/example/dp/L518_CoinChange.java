package com.example.dp;

/**
 * <p>L518:零钱兑换II</p>
 * <p>
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 * </p>
 */
public class L518_CoinChange {
    public static void main(String[] args) {

    }


    /**
     * dp[i][j]:使用区间 [0..i] 里的硬币，恰好可以凑出面值为 j 的方案总数
     */
    public static int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            return amount == 0 ? 1 : 0;
        }

        // 初始化dp
        int[][] dp = new int[len][amount + 1];
        dp[0][0] = 1;
        for (int j = coins[0]; j <= amount; j+=coins[0]) {
            dp[0][j] = 1;
        }

        // 开始递推
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i] >= 0) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }

        return dp[len - 1][amount];
    }
}
