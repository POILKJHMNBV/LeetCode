package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L2563:统计公平数对的数目</p>
 * @author zhenwu
 * @date 2025/3/16 21:34
 */
public class L2563_CountFairPairs {
    public static void main(String[] args) {
        int[] nums = {0, 1, 7, 4, 4, 5};
        int lower = 3, upper = 6;
        System.out.println(countFairPairsPro(nums, lower, upper));
        System.out.println(countFairPairs(nums, lower, upper));
    }

    /**
     * lower <= nums[i] + nums[j] <= upper      =>      lower - nums[j] <= nums[i] <= upper - nums[j]
     * 三指针
     * 时间复杂度: O(n * log n)
     * 空间复杂度: O(1)
     */
    private static long countFairPairsPro(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        int n = nums.length, l = n, r = n;
        for (int j = 0; j < n; j++) {
            while (r > 0 && nums[r - 1] + nums[j] > upper) {
                // 求出nums[i]的上界
                r--;
            }
            // nums[r - 1] + nums[j] <= upper   nums[r] + nums[j] >= upper
            while (l > 0 && nums[l - 1]  + nums[j] >= lower) {
                // 求出nums[i]的下界
                l--;
            }
            // nums[l - 1] + nums[j] < lower   nums[l] + nums[j] >= lower
            // [l, r)
            ans += Math.min(r, j) - Math.min(l, j);
        }
        return ans;
    }

    /**
     * 暴力求解(超时)
     * 时间复杂度: O(n * n)
     * 空间复杂度: O(1)
     */
    private static long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; j++) {
                long sum = nums[i] + nums[j];
                if (sum >= lower && sum <= upper) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
