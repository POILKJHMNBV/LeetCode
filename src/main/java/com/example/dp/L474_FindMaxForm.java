package com.example.dp;

/**
 * <p>L474:一和零</p>
 * <p>
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * </p>
 */
public class L474_FindMaxForm {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(findMaxForm(strs, m, n));
    }

    /**
     * dp[i][j][k]:在[0...i]区间内最多 有 j 个 0 和 k 个 1 的最大子集长度
     */
    private static int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            int[] counter = counter(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // 当前字符串不选
                    dp[i][j][k] = dp[i - 1][j][k];
                    int zeros = counter[0];
                    int ones = counter[1];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    private static int[] counter(String str) {
        int[] res = new int[2];
        char[] charArray = str.toCharArray();
        for (char ch : charArray) {
            res[ch - '0']++;
        }
        return res;
    }
}
