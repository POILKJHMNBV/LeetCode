package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L976:三角形的最大周长</p>
 * @author zhenwu
 * @date 2025/9/24 21:46
 */
public class L976_LargestPerimeter {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(log n)
     */
    private static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
