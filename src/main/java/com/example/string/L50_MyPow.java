package com.example.string;

/**
 * <p>L50:Pow(x, n)</p>
 * @author zhenwu
 * @date 2024/9/28 21:40
 */
public class L50_MyPow {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
        System.out.println(Math.pow(x, n));
    }

    /**
     * 时间：O(log n)      空间：O(1)
     */
    private static double myPow(double x, int n) {
        long N = n;
        if (N == 0) {
            return 1;
        }
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1;
        while (N > 0) {
            if ((N & 1) == 1) { // 如果N是奇数
                result *= x;
            }
            x *= x; // x^2
            N >>= 1; // N除以2
        }
        return result;
    }
}
