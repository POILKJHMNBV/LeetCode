package com.example.slidewindow;

import java.util.TreeMap;

/**
 * <p>L1438:绝对差不超过限制的最长连续子数组</p>
 * @author zhenwu
 * @date 2025/2/23 9:25
 */
public class L1438_LongestSubarray {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口 + 树状数组
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        int n = nums.length, maxLen = 0;
        for (int l = 0, r = 0; r < n; r++) {
            cntMap.merge(nums[r], 1, Integer::sum);
            while (cntMap.lastKey() - cntMap.firstKey() > limit) {
                int out = nums[l++];
                cntMap.merge(out, -1, Integer::sum);
                if (cntMap.get(out) == 0) {
                    cntMap.remove(out);
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
