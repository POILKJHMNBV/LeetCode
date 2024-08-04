package com.example.dp;

import java.util.Arrays;

/**
 * <p>L1049:最后一块石头的重量II</p>
 * <p>
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * </p>
 */
public class L1049_LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }

    /**
     * ① sum(所有添加正号的数) + sum(所有添加负号的数) = sum
     * ② sum(所有添加正号的数) - sum(所有添加负号的数) = target
     * ① - ② 得：
     * 2 * sum(所有添加负号的数) = sum - target, 其中 target >= 0, 则有 sum(所有添加负号的数) <= 2/sum
     * dp[i][j]:[0...i]区间内和小于等于 2/sum 的最大值
     */
    private static int lastStoneWeight(int[] stones) {
        int len = stones.length;
        if (len == 1) {
            return stones[0];
        }
        int sum = Arrays.stream(stones).sum();
        int cols = sum / 2 + 1;

        // 初始化dp
        int[][] dp = new int[len][cols];
        for (int j = 0; j < cols; j++) {
            if (stones[0] <= j) {
                dp[0][j] = stones[0];
            }
        }

        // 开始递推
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = dp[i - 1][j];
                if (stones[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }

        return sum - 2 * dp[len - 1][cols - 1];
    }
}
