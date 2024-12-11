package com.example.num;

import java.util.Arrays;

/**
 * <p>L891:子序列宽度之和</p>
 * @author zhenwu
 * @date 2024/12/11 22:06
 */
public class L891_SumSubseqWidths {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        System.out.println(sumSubseqWidths(nums));
    }

    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    private static int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums); // 排序
        int mod = (int)1e9 + 7, n = nums.length;
        long result = 0;
        long[] pow = new long[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] << 1) % mod; // 初始化2^n的值
        }

        for (int i = 0; i < n; i++) {
            result = (result + (pow[i] - pow[n - i - 1]) * nums[i] % mod) % mod; // 计算总和
        }
        return (int)result;
    }
}
