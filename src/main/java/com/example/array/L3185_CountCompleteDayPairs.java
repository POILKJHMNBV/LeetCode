package com.example.array;

/**
 * <p>L3185:构成整天的下标对数目 II</p>
 * @author zhenwu
 * @date 2025/5/2 9:34
 * @see L1010_NumPairsDivisibleBy60
 */
public class L3185_CountCompleteDayPairs {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static long countCompleteDayPairs(int[] hours) {
        long ans = 0;
        long[] cnt = new long[24];
        for (int hour : hours) {
            ans += cnt[(24 - hour % 24) % 24];
            cnt[hour % 24]++;
        }
        return ans;
    }
}
