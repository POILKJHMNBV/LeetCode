package com.example.dp;

/**
 * <p>L790:多米诺和托米诺平铺</p>
 * @author zhenwu
 * @date 2024/9/17 10:08
 */
public class L790_NumTilings {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(n)  空间：O(n)
     * 使用 dp[i][s] 表示平铺到第 i 列时，各个状态 s 对应的平铺方法数量
     * 0 - 一个正方形都没有被覆盖
     * 1 - 只有上方的正方形被覆盖
     * 2 - 只有下方的正方形被覆盖
     * 3 - 上下两个正方形都被覆盖
     */
    private static int numTilings(int n) {
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][4];
        dp[1][0] = dp[1][3] =  1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
        }
        return dp[n][3];
    }
}
