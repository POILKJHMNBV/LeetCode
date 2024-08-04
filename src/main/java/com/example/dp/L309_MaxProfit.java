package com.example.dp;

import java.util.Arrays;

/**
 * <p>L309:买卖股票的最佳时机含冷冻期</p>
 * <p>给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。</p>
 * <p>设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:</p>
 * <p>卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。</p>
 * <p>注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>
 */
public class L309_MaxProfit {
    public static void main(String[] args) {

    }

    /**
     * 1、dp[i][j]: 第i天处于j状态所能获得的最大收益
     * 2、状态设计
     *     0-持有股票
     *     1-股票今天刚卖出
     *     2-股票早已卖出，一直没买
     *     3-冷冻期
     * 3、递推公式：
     *     dp[i][0] = max(dp[i - 1][0], dp[i - 1][2] - prices[i], dp[i - 1][3] - prices[i])
     *     dp[i][1] = dp[i - 1][0] + prices[i];
     *     dp[i][2] = max(dp[i - 1][2], dp[i - 1][3])
     *     dp[i][3] = dp[i - 1][1]
     */
    private static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        // 初始化dp
        int[][] dp = new int[len][4];
        dp[0][0] = -prices[0];

        // 开始递推
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]), dp[i - 1][3] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][3]);
            dp[i][3] = dp[i - 1][1];
        }

        return Math.max(Math.max(dp[len - 1][1], dp[len - 1][2]), dp[len - 1][3]);
    }
}
