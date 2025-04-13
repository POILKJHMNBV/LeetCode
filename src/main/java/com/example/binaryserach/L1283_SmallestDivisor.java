package com.example.binaryserach;

import java.util.Arrays;

/**
 * <p>L1283:使结果不超过阈值的最小除数</p>
 * @author zhenwu
 * @date 2025/4/13 21:31
 */
public class L1283_SmallestDivisor {
    public static void main(String[] args) {
        int[] nums = {44, 22, 33, 11, 1};
        int threshold = 5;
        System.out.println(smallestDivisor(nums, threshold));
    }

    /**
     * 时间：O(n log n)
     * 空间：O(1)
     */
    private static int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1];
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (sum(nums, m) > threshold) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private static int sum(int[] nums, int k) {
        int ans = 0;
        for (int num : nums) {
            ans += Math.ceil(num * 1.0 / k);
        }
        return ans;
    }
}
