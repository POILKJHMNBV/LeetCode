package com.example.dp;

/**
 * <p>L152:乘积最大子数组</p>
 * <p>给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。</p>
 */
public class L152_MaxProduct {
    public static void main(String[] args) {
        int[] nums = {-2, 0, -1};
        System.out.println(maxProduct(nums));
        System.out.println(maxProductPro(nums));
    }

    private static int maxProductPro(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);
            max = Math.max(imax, max);
        }
        return max;
    }

    private static int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int max = 1, res = nums[0];
        for (int num : nums) {
            max *= num;
            res = Math.max(res, max);
            if (max == 0) {
                max = 1;
            }
        }

        max = 1;
        for (int i = len - 1; i >= 0; i--) {
            max *= nums[i];
            res = Math.max(res, max);
            if (max == 0) {
                max = 1;
            }
        }
        return res;
    }
}
