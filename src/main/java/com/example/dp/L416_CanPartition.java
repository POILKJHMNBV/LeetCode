package com.example.dp;

import java.util.Arrays;

/**
 * <p>L416:分割等和子集</p>
 * <p>给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。</p>
 */
public class L416_CanPartition {
    public static void main(String[] args) {

    }

    /**
     * dp[i][j]:[0...i]区间内是否存在部分和为j的子集
     * 抽象为背包问题
     */
    private static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int len = nums.length;

        // 初始化dp
        boolean[][] dp = new boolean[len][target + 1];
        dp[0][0] = true;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // 开始递推
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[len - 1][target];
    }
}
