package com.example.slidewindow;

import java.util.Arrays;

/**
 * <p>L2779:数组的最大美丽值</p>
 * @author zhenwu
 * @date 2025/2/16 10:29
 */
public class L2779_MaximumBeauty {
    public static void main(String[] args) {

    }

    /**
     * x + k >= y - k => y - x <= 2k
     * 思路：排序后，找最长的连续子数组，其最大值减最小值 ≤ 2k。由于数组是有序的，相当于子数组的最后一个数减去子数组的第一个数 ≤ 2k。
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(1)
     */
    private static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0;
        for (int l = 0, r = 0, n = nums.length; r < n; r++) {
            while (nums[r] - nums[l] > 2 * k) l++;
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
