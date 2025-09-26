package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L3627:中位数之和的最大值</p>
 * @author zhenwu
 * @date 2025/9/26 20:56
 * @see L1561_MaxCoins
 */
public class L3627_MaximumMedianSum {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(log n)
     */
    private static long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        long res = 0;
        for (int i = nums.length / 3; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
