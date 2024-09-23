package com.example.dp;

/**
 * <p>L714:买卖股票的最佳时机含手续费</p>
 *
 * @author zhenwu
 * @date 2024/9/23 20:32
 */
public class L714_MaxProfit {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     */
    private int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }

        /*
            dp[i][0] 表示第 i 天持有股票所得最多现金
            dp[i][1] 表示第 i 天不持有股票所得最多现金
            dp[0][0] = -prices[0]
            dp[0][1] = 0
        */
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]); // 买入股票，或者前一天就持有股票
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]); // 不操作，或者前一天就不持有股票，然后今天卖出
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
