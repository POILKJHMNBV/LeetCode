package com.example.doublepointer;

/**
 * <p>L2970:统计移除递增子数组的数目 I</p>
 * @author zhenwu
 * @date 2025/3/2 21:13
 */
public class L2870_IncremovableSubarrayCount {
    public static void main(String[] args) {
        int[] nums = {6, 5, 7, 8};
        System.out.println(incremovableSubarrayCount(nums));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int incremovableSubarrayCount(int[] nums) {
        int n = nums.length, i = 0;
        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return n * (n + 1) / 2;
        }

        // 不保留后缀的情况，一共可以移除 i+2 个子数组
        int ans = i + 2;
        for (int j = n - 1; j == n - 1 || nums[j] < nums[j + 1]; j--) {
            while (i >= 0 && nums[i] >= nums[j]) {
                // 前缀数组右端点 >= 后缀数组左端点
                i--;
            }
            // 可以移除区间为[k, j - 1], 其中 0 <= k <= i + 1
            ans += i + 2;
        }
        return ans;
    }
}
