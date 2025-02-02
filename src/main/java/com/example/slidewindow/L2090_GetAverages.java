package com.example.slidewindow;

import java.util.Arrays;

/**
 * <p>L2090:半径为 k 的子数组平均值</p>
 * @author zhenwu
 * @date 2025/2/2 16:14
 */
public class L2090_GetAverages {
    public static void main(String[] args) {
        int[] nums = {8};
        int k = 0;
        System.out.println(Arrays.toString(getAverages(nums, k)));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int[] getAverages(int[] nums, int k) {
        int n = nums.length, d = 2 * k + 1;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if (d > n) {
            return res;
        }
        long sum = 0;
        for (int i = 0; i < d; i++) {
            sum += nums[i];
        }
        res[k] = (int) (sum / d);
        int l = 0, r = d;
        while (r < n) {
            sum += (nums[r++] - nums[l++]);
            res[++k] = (int) (sum / d);
        }
        return res;
    }
}
