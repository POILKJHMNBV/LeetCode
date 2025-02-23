package com.example.slidewindow;

/**
 * <p>L2401:最长优雅子数组</p>
 * @author zhenwu
 * @date 2025/2/23 10:52
 */
public class L2401_LongestNiceSubarray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 48, 10};
        System.out.println(longestNiceSubarray(nums));
    }

    /**
     * 滑动窗口 + 位运算
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int longestNiceSubarray(int[] nums) {
        int n = nums.length, maxLen = 1;
        for (int l = 0, r = 0, nor = 0; r < n; r++) {
            // nor代表已经加入的元素集合
            while ((nor & nums[r]) > 0) {
                // 当前元素不能加入窗口，缩小窗口
                nor ^= nums[l++];
            }
            // 加入当前元素
            nor |= nums[r];
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
