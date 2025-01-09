package com.example.bit;

/**
 * <p>L342:4的幂</p>
 * <p>给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。</p>
 * @author zhenwu
 * @date 2025/1/9 21:49
 */
public class L342_IsPowerOfFour {
    public static void main(String[] args) {

    }

    private static boolean isPowerOfFour(int n) {
        return (n & (n - 1)) == 0 && (n % 3) == 1;
    }
}
