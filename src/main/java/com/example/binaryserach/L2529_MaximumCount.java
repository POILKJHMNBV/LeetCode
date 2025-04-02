package com.example.binaryserach;

/**
 * <p>L2529:正整数和负整数的最大计数</p>
 * @author zhenwu
 * @date 2025/4/2 10:09
 */
public class L2529_MaximumCount {

    public static void main(String[] args) {
        int[] nums = {-2, -2, -1};
        System.out.println(maximumCount(nums));
    }

    /**
     * 时间：O(log n)  空间：O(1)
     */
    private static int maximumCount(int[] nums) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < 0) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int j = l;
        while (j < nums.length && nums[j] == 0) {
            j++;
        }
        return Math.max(l, nums.length - j);
    }
}
