package com.example.dp;

/**
 * <p>L343:整数拆分</p>
 * <p>给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。</p>
 */
public class L343_IntegerBreak {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }

    /**
     * 拆分成m个近似相等的数，值越大
     */
    private static int integerBreak(int n) {
        // dp[i]表示i进行拆分所获得的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]), dp[i]);
            }
        }
        return dp[n];
    }
}
