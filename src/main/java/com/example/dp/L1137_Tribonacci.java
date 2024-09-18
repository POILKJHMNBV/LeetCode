package com.example.dp;

/**
 * <p>L1137:第 N 个泰波那契数</p>
 * @author zhenwu
 * @date 2024/9/17 9:41
 */
public class L1137_Tribonacci {
    public static void main(String[] args) {
        int n = 25;
        System.out.println(tribonacci(n));
    }

    /**
     * 时间：O(n)  空间：O(1)
     */
    private static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        int a = 0, b = 1, c = 1;
        while (n >= 3) {
            int temp = a + b + c;
            a = b;
            b = c;
            c = temp;
            n--;
        }
        return c;
    }
}
