package com.example.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L2958:最多 K 个重复元素的最长子数组</p>
 * @author zhenwu
 * @date 2025/2/11 22:29
 */
public class L2958_MaxSubarrayLength {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口 + 哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int maxLen = 0;
        for (int i = 0, j = 0; j < nums.length; ++j) {
            cntMap.put(nums[j], cntMap.getOrDefault(nums[j], 0) + 1);
            while (cntMap.get(nums[j]) > k) {
                cntMap.put(nums[i], cntMap.get(nums[i]) - 1);
                if (cntMap.get(nums[i]) == 0) {
                    cntMap.remove(nums[i]);
                }
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
