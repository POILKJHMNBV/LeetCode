package com.example.slidewindow;

import java.util.Arrays;

/**
 * <p>L1984:学生分数的最小差值</p>
 * @author zhenwu
 * @date 2025/2/9 9:25
 */
public class L1984_MinimumDifference {

    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n logn)
     * 空间复杂度：O(1)
     */
    private static int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }
}
