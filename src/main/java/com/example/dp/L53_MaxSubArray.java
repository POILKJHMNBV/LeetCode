package com.example.dp;

import java.util.Arrays;

/**
 * <p>L53:最大子数组和</p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
public class L53_MaxSubArray {
    public static void main(String[] args) {

    }

    /**
     * dp[i]: dp[i] 表示以 nums[i] 结尾的连续子数组的最大和
     * dp[i] = nums[i] + max(dp[i - 1], 0)
     */
    private static int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i <len; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
        }
        Arrays.sort(dp);
        return dp[len - 1];
    }

    private static int maxSubArrayPro(int[] nums) {
        int len = nums.length;
        int pre = nums[0];
        int res = pre;
        for (int i = 1; i <len; i++) {
            pre = nums[i] + Math.max(pre, 0);
            res = Math.max(res, pre);
        }
        return res;
    }
}
