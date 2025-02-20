package com.example.slidewindow;

/**
 * <p>L2302:统计得分小于 K 的子数组数目</p>
 * @author zhenwu
 * @date 2025/2/20 21:07
 */
public class L2302_CountSubarrays {
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 5};
        int k = 10;
        System.out.println(countSubarrays(nums, k));
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static long countSubarrays(int[] nums, long k) {
        long ans = 0, sum = 0;
        for (int l = 0, r = 0, n = nums.length; r < n; r++) {
            sum += nums[r];
            while (sum * (r - l + 1) >= k) {
                sum -= nums[l++];
            }
            ans += (r - l + 1);
        }
        return ans;
    }
}
