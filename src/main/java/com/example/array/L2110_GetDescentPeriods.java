package com.example.array;

/**
 * <p>L2110:股票平滑下跌阶段的数目</p>
 * @author zhenwu
 * @date 2025/3/22 9:56
 */
public class L2110_GetDescentPeriods {
    public static void main(String[] args) {
        int[] prices = {3, 2, 1, 4};
        System.out.println(getDescentPeriods(prices));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static long getDescentPeriods(int[] prices) {
        long ans = 0;
        for (int i = 0, n = prices.length; i < n; i++) {
            int j = i + 1;
            while (j < n && prices[j] + 1 == prices[j - 1]) {
                j++;
            }
            int x = j - i;
            ans += (long) x * (x + 1) / 2;
            i = j - 1;
        }
        return ans;
    }
}
