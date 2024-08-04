package com.example.dp;

/**
 * <p>L509:斐波那契数</p>
 * <p>斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：</p>
 * <p>F(0) = 0，F(1) = 1</p>
 * <p>F(n) = F(n - 1) + F(n - 2)，其中 n > 1</p>
 * <p>给定 n ，请计算 F(n)</p>
 */
public class L509_Fib {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fib(n));
    }

    private static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0, b = 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
