package com.example.array;

/**
 * <p>L121:买卖股票的最佳时机</p>
 * <p>给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。</p>
 * <p>你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。</p>
 */
public class L121_MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitPro(prices));
    }

    /**
     * 动态规划解法
     * dp[i][j]表示第i天处于状态j时的最大利润  j=0表示持有股票，j=1表示不持有股票
     * dp[i][0] = max(dp[i-1][0], -prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i])
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int maxProfitPro(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
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
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
}
