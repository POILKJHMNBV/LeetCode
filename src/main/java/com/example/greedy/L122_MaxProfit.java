package com.example.greedy;

/**
 * <p>L122:买卖股票的最佳时机 II</p>
 * <p>给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。</p>
 * <p>在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。</p>
 */
public class L122_MaxProfit {
    public static void main(String[] args) {

    }

    /**
     * 动态规划解法
     * dp[i][j]表示第i天处于状态j时的最大利润  j=0表示持有股票，j=1表示不持有股票
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i])
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int maxProfitPro(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[n - 1][1];
    }

    /**
     * 贪心解法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(prices[i] - prices[i - 1], 0);
        }
        return res;
    }
}
