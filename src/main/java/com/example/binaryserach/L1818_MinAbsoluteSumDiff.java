package com.example.binaryserach;

import java.util.Arrays;

/**
 * <p>L1818:绝对差值和</p>
 * @author zhenwu
 * @date 2025/4/10 22:40
 */
public class L1818_MinAbsoluteSumDiff {

    public static void main(String[] args) {

    }

    /**
     * 时间：O(n log n)
     * 空间：O(n)
     */
    private static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1000000007, n = nums1.length;
        int[] sortedNums1 = Arrays.copyOf(nums1, n);
        Arrays.sort(sortedNums1);
        int sum = 0, maxDiff = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                continue;
            }
            int d = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + d) % MOD;
            int idx = search(sortedNums1, nums2[i]);
            if (idx < n) {
                maxDiff = Math.max(maxDiff, d - (sortedNums1[idx] - nums2[i]));
            }
            if (idx > 0) {
                maxDiff = Math.max(maxDiff, d - (nums2[i] - sortedNums1[idx - 1]));
            }
        }
        return (sum - maxDiff + MOD) % MOD;
    }

    private static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) /2;
            if (nums[m] == target) {
                return m;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
