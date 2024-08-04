package com.example.slidewindow;

/**
 * <p>L209:长度最小的子数组</p>
 * <p>给定一个含有 n 个正整数的数组和一个正整数 target 。</p>
 * <p>找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。</p>
 */
public class L209_MinSubArrayLen {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int res = 0;
        int begin = 0, end = 0;
        int sum = nums[0];
        while (begin < len) {
            if (sum >= target) {
                res = res == 0 ? end - begin + 1 : Math.min(res, end - begin + 1);
                sum -= nums[begin];
                begin++;
            } else {
                end++;
                if (end == len) {
                    break;
                }
                sum += nums[end];
            }
        }
        return res;
    }
}
