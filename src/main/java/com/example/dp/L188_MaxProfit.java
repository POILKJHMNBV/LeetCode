package com.example.dp;

/**
 * <p>L188:买卖股票的最佳时机 IV</p>
 * <p>给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。</p>
 * <p>设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。</p>
 * <p>注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>
 */
public class L188_MaxProfit {
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {2, 4, 1};
        System.out.println(maxProfit(k, prices));
    }

    /**
     * 0-第一次持有股票     1-第一次不持有股票     2-第二次持有股票     3-第二次不持有股票   ...  2k-2 - 第k次持有股票     2k-1 - 第k次不持有股票
     * dp[i][j]: 第i天处于j状态所能获得的最大收益
     * 递推公式：
     * dp[i][0] = max(dp[i - 1][0], - prices[i])
     * dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i])
     * dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] - prices[i])
     * dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] + prices[i])
     * ...
     * dp[i][2k - 2] = max(dp[i - 1][2k - 2], dp[i - 1][2k - 3] - prices[i])
     * dp[i][2k - 1] = max(dp[i - 1][2k - 1], dp[i - 1][2k - 2] + prices[i])
     */
    private static int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        // 初始化dp
        int state = 2 * k - 1;
        int[][] dp = new int[len][2 * k];
        for (int i = 0; i <= state; i++) {
            if (i % 2 == 0) {
                dp[0][i] = -prices[0];
            }
        }

        // 开始递推
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= state; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][0], -prices[i]);
                } else if (j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[len - 1][state];
    }
}
