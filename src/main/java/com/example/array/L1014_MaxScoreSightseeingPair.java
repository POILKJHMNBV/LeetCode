package com.example.array;

/**
 * <p>L1014:最佳观光组合</p>
 * @author zhenwu
 * @date 2025/5/4 9:56
 */
public class L1014_MaxScoreSightseeingPair {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int maxScoreSightseeingPair(int[] values) {
        int ans = Integer.MIN_VALUE, preMax = 0;
        for (int i = 0, n = values.length; i < n; i++) {
            ans = Math.max(ans, preMax + values[i] - i);
            preMax = Math.max(preMax, values[i] + i);
        }
        return ans;
    }
}
