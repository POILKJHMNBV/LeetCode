package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>LCP18:早餐组合</p>
 * @author zhenwu
 * @date 2025/3/7 19:38
 */
public class LCP18_BreakfastNumber {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 时间复杂度: O(m log m) + O(n log n)
     * 空间复杂度: O(1)
     */
    private static int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int m = staple.length, n = drinks.length;
        int ans = 0;
        for (int i = 0, j = n - 1; i < m; ++i) {
           while (j >= 0 && staple[i] + drinks[j] > x) j--;
           if (j == -1) break;
           ans += (j + 1);
           ans %= 1000000007;
        }
        return ans;
    }
}
