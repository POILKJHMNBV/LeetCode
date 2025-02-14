package com.example.slidewindow;

import java.util.Arrays;

/**
 * <p>L2009:使数组连续的最少操作数</p>
 * @author zhenwu
 * @date 2025/2/14 22:06
 */
public class L2009_MinOperations {
    public static void main(String[] args) {

    }

    /**
     * 排序 + 双指针去重 + 滑动窗口
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(1)
     * 使数组连续的最少操作数
     * 思路：正难则反，使数组连续需要保留的最多操作数
     */
    private static int minOperations(int[] nums) {
        Arrays.sort(nums);
        // 双指针去重
        int m = 1, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }

        int maxOps = 0;
        for (int l = 0, r = 0; r < m; r++) {
            while (nums[r] - n + 1 > nums[l]) {
                l++;
            }
            maxOps = Math.max(maxOps, r - l + 1);
        }
        return n - maxOps;
    }
}
