package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L1005:K 次取反后最大化的数组和</p>
 * @author zhenwu
 * @date 2025/9/14 19:44
 */
public class L1005_LargestSumAfterKNegations {
    public static void main(String[] args) {
        int[] nums = {-4, -2, -3};
        int k = 4;
        System.out.println(largestSumAfterKNegations(nums, k));
    }

    /**
     * 时间复杂度: O(nlogn)
     * 空间复杂度: O(1)
     */
    private static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0, min = 1000;
        for (int num : nums) {
            if (num < 0 && k > 0) {
                num = -num;
                k--;
            }
            sum += num;
            min = Math.min(min, num);
        }
        return sum - (k % 2 == 1 ? 2 * min : 0);
    }
}
