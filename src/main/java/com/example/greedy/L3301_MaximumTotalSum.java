package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L3301:高度互不相同的最大塔高和</p>
 * @author zhenwu
 * @date 2025/9/29 20:45
 */
public class L3301_MaximumTotalSum {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        int n = maximumHeight.length;
        long sum = maximumHeight[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (maximumHeight[i + 1] - 1 <= 0) {
                return -1;
            }
            maximumHeight[i] = Math.min(maximumHeight[i], maximumHeight[i + 1] - 1);
            sum += maximumHeight[i];
        }
        return sum;
    }
}
