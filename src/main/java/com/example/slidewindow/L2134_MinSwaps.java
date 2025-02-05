package com.example.slidewindow;

/**
 * <p>L2134:最少交换次数来组合所有的 1 II</p>
 * @author zhenwu
 * @date 2025/2/5 20:53
 */
public class L2134_MinSwaps {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int minSwaps(int[] nums) {
        int totalOneCount = 0;
        for (int num : nums) {
            if (num == 1) {
                totalOneCount++;
            }
        }
        int n = nums.length;
        if (totalOneCount < 2 || totalOneCount == n) {
            return 0;
        }
        int oneCount = 0;
        for (int i = 0; i < totalOneCount; i++) {
            if (nums[i] == 1) {
                oneCount++;
            }
        }
        int l = 0, r = totalOneCount, maxContinuousOneCount = oneCount;
        while (r < 2 * n) {
            if (nums[r % n] == 1) {
                oneCount++;
            }
            if (nums[l % n] == 1) {
                oneCount--;
            }
            maxContinuousOneCount = Math.max(oneCount, maxContinuousOneCount);
            l++;
            r++;
        }
        return totalOneCount - maxContinuousOneCount;
    }
}
