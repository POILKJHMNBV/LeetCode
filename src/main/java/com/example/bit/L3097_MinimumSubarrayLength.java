package com.example.bit;

/**
 * <p>L3097:或值至少为 K 的最短子数组 II</p>
 * @author zhenwu
 * @date 2025/7/21 22:03
 */
public class L3097_MinimumSubarrayLength {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n * logU), 其中 n 是 nums 的长度，U=max(nums)
     * 空间复杂度：O(1)
     */
    private static int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0, n = nums.length; i < n; i++) {
            int x = nums[i];
            if (x >= k) {
               return 1;
            }
            for (int j = i - 1; j >= 0 && (nums[j] | x) != nums[j]; j--) {
                nums[j] |= x;
                if (nums[j] >= k) {
                    ans = Math.min(ans, i - j + 1);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
