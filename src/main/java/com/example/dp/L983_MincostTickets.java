package com.example.dp;

/**
 * <p>L983: 最低票价</p>
 * <p>在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。</p>
 * <p>
 * 火车票有 三种不同的销售方式 ：
 * 一张 为期一天 的通行证售价为 costs[0] 美元；
 * 一张 为期七天 的通行证售价为 costs[1] 美元；
 * 一张 为期三十天 的通行证售价为 costs[2] 美元。
 * </p>
 * <p>通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。</p>
 * <p>返回 你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费 。</p>
 */
public class L983_MincostTickets {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20}, costs = {2, 7, 15};
        System.out.println(mincostTickets(days, costs));
    }

    /**
     * 思路: 「今天买多少，得看后几天怎么安排」，即「前面依赖后面」——从后向前来买。
     * dp[i]：第 i 天开始，所需最小费用累计
     * dp[i] = min(c[0] + dp[i + 1], c[1] + dp[i + 7], c[2] + dp[i + 30])
     */
    private static int mincostTickets(int[] days, int[] costs) {
        int len = days.length, maxDay = days[len - 1], minDay = days[0];
        int[] dp = new int[maxDay + 31];
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            if (days[i] == d) {
                // 今天需要买票，考虑怎样买票最省
                dp[d] = Math.min(Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]), dp[d + 30] + costs[2]);

                // 天数减一天
                i--;
            } else {
                // 今天不需要出门
                dp[d] = dp[d + 1];
            }
        }
        return dp[minDay];
    }
}
