package com.example.dp;

/**
 * <p>L313:超级丑数</p>
 * @author zhenwu
 * @date 2024/12/5 21:47
 */
public class L313_NthSuperUglyNumber {
    public static void main(String[] args) {
        int n = 10;
        int[] primes = {2, 7, 13, 19};
        System.out.println(nthSuperUglyNumber(n, primes));
    }

    /**
     * 动态规划
     * 时间复杂度：O(n*m)，其中 n 是要找的第 n 个丑数，m 是质数的个数
     * 空间复杂度：O(n + m)
     */
    private static int nthSuperUglyNumber(int n, int[] primes) {
        int pLen = primes.length;
        int[] indexes = new int[pLen];

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // 因为选最小值，先假设一个最大值
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < pLen; j++) {
                dp[i] = (int) Math.min(dp[i], (long) dp[indexes[j]] * primes[j]);
            }

            // dp[i] 是之前的哪个丑数乘以对应的 primes[j] 选出来的，给它加 1
            for (int j = 0; j < pLen; j++) {
                if (dp[i] == dp[indexes[j]] * primes[j]) {
                    // 注意：这里不止执行一次，例如选出 14 的时候，2 和 7 对应的最小丑数下标都要加 1，大家可以打印 indexes 和 dp 的值加以验证
                    indexes[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
