package com.example.slidewindow;

/**
 * <p>L2875:无限数组的最短子数组</p>
 * @author zhenwu
 * @date 2025/2/17 20:16
 */
public class L2875_MinSizeSubarray {

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 7, 7, 1, 6, 3};
        int target = 39;
        System.out.println(minSizeSubarray(nums, target));
    }

    /**
     * 滑动窗口
     * 无限数组的最短子数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int minSizeSubarray(int[] nums, int target) {
        int n = nums.length, minLen = Integer.MAX_VALUE;
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        for (int l = 0, r = 0, sum = 0; r < 2 * n; r++) {
            sum += nums[r % n];
            while (sum > target % total) {
                sum -= nums[l++ % n];
            }
            if (sum == target % total) {
                minLen = Math.min(minLen, r - l + 1);
            }
        }
        return minLen == Integer.MAX_VALUE? -1 : minLen + (int) (target / total) * n;
    }
}
