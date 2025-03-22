package com.example.array;

/**
 * <p>L2760:最长奇偶子数组</p>
 * @author zhenwu
 * @date 2025/3/22 10:04
 */
public class L2760_LongestAlternatingSubarray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 4};
        int threshold = 5;
        System.out.println(longestAlternatingSubarray(nums, threshold));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLen = 0;
        for (int i = 0, n = nums.length; i < n; i++) {
            if (nums[i] % 2 != 0 || nums[i] > threshold) {
                continue;
            }
            int j = i + 1;
            while (j < n && nums[j] <= threshold && (nums[j] + nums[j - 1]) % 2 != 0) {
                j++;
            }
            maxLen = Math.max(maxLen, j - i);
            i = j - 1;
        }
        return maxLen;
    }
}
