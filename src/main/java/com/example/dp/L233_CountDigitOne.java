package com.example.dp;

/**
 * <p>L233:数字 1 的个数</p>
 * @author zhenwu
 * @date 2024/11/18 21:29
 */
public class L233_CountDigitOne {
    public static void main(String[] args) {

    }

    /**
     * 计算数字 1 的个数
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     */
    private static int countDigitOne(int n) {
        int count = 0;
        long multiplier = 1;
        while (multiplier <= n) {
            long divider = multiplier * 10;
            count += (n / divider) * multiplier + Math.min(Math.max(n % divider - multiplier + 1, 0), multiplier);
            multiplier = divider;
        }
        return count;
    }
}
