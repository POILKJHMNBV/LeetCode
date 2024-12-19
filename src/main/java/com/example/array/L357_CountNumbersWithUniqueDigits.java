package com.example.array;

/**
 * <p>L357:统计各位数字都不同的数字个数</p>
 * <p>给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n </p>
 * @author zhenwu
 * @date 2024/12/19 22:04
 */
public class L357_CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(countNumbersWithUniqueDigits(n));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; ++i) {
            cur *= (9 - i);
            res += cur;
        }
        return res;
    }
}
