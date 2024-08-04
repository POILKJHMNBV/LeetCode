package com.example.dp;

import java.util.Arrays;

/**
 * <p>L494:目标和</p>
 * <p>
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * </p>
 */
public class L494_FindTargetSumWays {
    public static void main(String[] args) {
        int[] nums = {1000};
        int target = -1000;
        System.out.println(findTargetSumWays(nums, target));
    }

    /**
     * dp[i][j]:[0...i]区间内和为 j - sum 的表达式数目
     */
    private static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target || -sum > target) {
            return 0;
        }
        int rows = nums.length;
        int cols = 2 * sum + 1;

        // 初始化dp
        int[][] dp = new int[rows][cols];
        dp[0][sum + nums[0]] = 1;
        // 防止nums[0]为0
        dp[0][sum - nums[0]] += 1;

        // 开始递推
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j >= nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
                if (j + nums[i] < cols) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
            }
        }
        return dp[rows - 1][target + sum];
    }
}
