package com.example.slidewindow;

import java.util.Arrays;

/**
 * <p>L643:子数组最大平均数 I</p>
 * @author zhenwu
 * @date 2024/9/1 10:14
 */
public class L643_FindMaxAverage {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    private static double findMaxAverage(int[] nums, int k) {
        int sum = Arrays.stream(nums, 0, k).sum();
        int l = 0, r = k - 1;
        double maxAverage = sum * 1.0 / k;
        while ((++r) < nums.length) {
            sum = sum - nums[l++] + nums[r];
            maxAverage = Math.max(maxAverage, sum * 1.0 / k);
        }
        return maxAverage;
    }
}
