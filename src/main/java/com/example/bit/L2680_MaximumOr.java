package com.example.bit;

/**
 * <p>L2680:最大或值</p>
 * @author zhenwu
 * @date 2025/7/15 21:46
 */
public class L2680_MaximumOr {
    public static void main(String[] args) {

    }

    /**
     * 要让答案最大，首先应当最大化答案的二进制长度
     * 把「乘 2」分配给多个数（雨露均沾），不如只分配给一个数，这样能得到更长（更大）的答案
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int[] suf = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = nums[i + 1] | suf[i + 1];
        }
        long ans = 0;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, pre | (long) nums[i] << k | suf[i]);
            pre |= nums[i];
        }
        return ans;
    }
}
