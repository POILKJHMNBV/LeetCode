package com.example.slidewindow;

/**
 * <p>L1004:最大连续1的个数 III</p>
 * <p>
 *     给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * </p>
 * @author zhenwu
 * @date 2024/9/1 10:45
 */
public class L1004_LongestOnes {
    public static void main(String[] args) {

    }

    private static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0, j = 0, tot = 0; i < n; i++) {
            tot += nums[i];
            while ((i - j + 1) - tot > k) tot -= nums[j++];
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}