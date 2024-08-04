package com.example.dp;

import java.util.Arrays;

/**
 * <p>L377:组合总和 Ⅳ</p>
 * <p>给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。</p>
 */
public class L377_CombinationSum4 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }

    /**
     * dp[i]: 和为i有几种组合
     * dp[i] += dp[i - num]
     */
    private static int combinationSum4(int[] nums, int target) {
        // 初始化dp
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
