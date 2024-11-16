package com.example.num;

/**
 * <p>L326:3 的幂</p>
 * @author zhenwu
 * @date 2024/11/16 21:47
 */
public class L326_IsPowerOfThree {
    public static void main(String[] args) {

    }

    private static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) n /= 3;
        return n == 1;
    }

    public static boolean isPowerOfThreePro(int n) {
        if (n <= 0) return false;
        return Math.log10(n) / Math.log10(3) % 1 == 0;
    }

    public static boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
