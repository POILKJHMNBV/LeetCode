package com.example.slidewindow;

import java.util.Arrays;

/**
 * <p>L1838:最高频元素的频数</p>
 * @author zhenwu
 * @date 2025/2/11 22:54
 */
public class L1838_MaxFrequency {
    public static void main(String[] args) {
        int[] nums = new int[30000];
        Arrays.fill(nums, 1);
        nums[nums.length - 1] = 100000;
        int k = 1;
        System.out.println(maxFrequency(nums, k));
    }

    /**
     * 滑动窗口 + 二分查找 + 排序 + 前缀和
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(nums, prefixSum, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static boolean check(int[] nums, long[] prefixSum, int len, int k) {
        int n = nums.length;
        for (int l = 0; l + len - 1 < n; ++l) {
            int r = l + len - 1;
            if ((long) nums[r] * len - (prefixSum[r + 1] - prefixSum[l]) <= k) {
                return true;
            }
        }
        return false;
    }
}
