package com.example.dp;

import java.util.Arrays;

/**
 * <p>L123:买卖股票的最佳时机 III</p>
 * <p>给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。</p>
 * <p>设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。</p>
 * <p>注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>
 */
public class L123_MaxProfit {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int maxProfitPro(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        int a = -prices[0], b = 0, c = -prices[0], d = 0;
        for (int i = 1; i < len; i++) {
            d = Math.max(d, c + prices[i]);
            c = Math.max(c, b - prices[i]);
            b = Math.max(b, a + prices[i]);
            a = Math.max(a, -prices[i]);
        }
        return d;
    }

    /**
     * 0 - 第一次持有股票     1 - 第一次不持有股票     2 - 第二次持有股票     3 - 第二次不持有股票
     * dp[i][j]: 第i天处于j状态所能获得的最大收益
     * 递推公式：
     * dp[i][0] = max(dp[i - 1][0], - prices[i])
     * dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i])
     * dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] - prices[i])
     * dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] + prices[i])
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        // 初始化dp
        int[][] dp = new int[len][4];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];

        // 开始递推
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[len - 1][3];
    }
}
