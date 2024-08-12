package com.example.binaryserach;

/**
 * <p>L367:有效的完全平方数</p>
 * <p>
 *     给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *     完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 *     不能使用任何内置的库函数，如  sqrt 。
 * </p>
 * @author zhenwu
 * @date 2024/8/12 20:54
 */
public class L367_IsPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(5));
        System.out.println(isPerfectSquare(808201));
        System.out.println(isPerfectSquare(1));
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(15));
        System.out.println(isPerfectSquare(8));
    }

    private static boolean isPerfectSquare(int num) {
        int l = 1, r = num / 2 + 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((num % m == 0) && (num / m == m)) {
                return true;
            } else if (num / m > m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
