package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L3075:幸福值最大化的选择方案</p>
 * @author zhenwu
 * @date 2025/9/20 21:24
 */
public class L3075_MaximumHappinessSum {
    public static void main(String[] args) {

    }

    /**
     * 贪心算法
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long ans = 0;
        for (int i = n - 1, j = 0; i >= n - k; i--, j++) {
            ans += Math.max(happiness[i] - j, 0);
        }
        return ans;
    }
}
