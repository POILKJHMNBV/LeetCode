package com.example.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L300:最长递增子序列</p>
 * <p>给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。</p>
 * <p>子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。</p>
 */
public class L300_LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(nums));
    }

    private static final Map<Integer, Integer> lengthMap = new HashMap<>();

    private static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            maxLen = Math.max(maxLen, process(nums,  i));
        }
        return maxLen;
    }

    private static int process(int[] nums, int startIndex) {
        if (lengthMap.containsKey(startIndex)) {
            return lengthMap.get(startIndex);
        }
        if (startIndex == nums.length - 1) {
            return 1;
        }
        int maxLen = 1;
        for (int i = startIndex + 1; i < nums.length; i++) {
            if (nums[i] > nums[startIndex]) {
                maxLen = Math.max(maxLen, process(nums, i) + 1);
            }
        }
        // 保存长度，避免重复计算
        lengthMap.put(startIndex, maxLen);
        return maxLen;
    }
}
