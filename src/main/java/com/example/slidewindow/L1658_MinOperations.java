package com.example.slidewindow;

/**
 * <p>L1658:将 x 减到 0 的最小操作数</p>
 * @author zhenwu
 * @date 2025/2/11 22:26
 */
public class L1658_MinOperations {

    public static void main(String[] args) {

    }

    /**
     * 滑动窗口(寻找值为 target 的最大窗口)
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        int ans = -1;
        int n = nums.length;
        for (int i = 0, j = 0, sum = 0; i < n; ++i) {
            sum += nums[i];
            while (j <= i && sum > target) {
                sum -= nums[j++];
            }
            if (sum == target) {
                ans = Math.max(ans, i - j + 1);
            }
        }
        return ans == -1 ? -1 : n - ans;
    }
}
