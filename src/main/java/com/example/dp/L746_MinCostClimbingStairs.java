package com.example.dp;

/**
 * <p>L746:使用最小花费爬楼梯</p>
 * <p>给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。</p>
 * <p>你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯</p>
 * <p>请你计算并返回达到楼梯顶部的最低花费。</p>
 */
public class L746_MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1, 100};
        System.out.println(minCostClimbingStairs(cost));
    }

    private static int minCostClimbingStairs(int[] cost) {
        // 到达i位置所需的最小花费
        // 由于可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯，那么dp[0] = 0, dp[1] = 0
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }
}
